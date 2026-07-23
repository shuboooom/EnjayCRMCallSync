package com.enjay.crm.callsync.data.sync

import androidx.room.withTransaction
import com.enjay.crm.callsync.data.local.AppDatabase
import com.enjay.crm.callsync.data.local.LeadCallLogEntity
import com.enjay.crm.callsync.data.local.LeadEntity
import com.enjay.crm.callsync.data.local.PostCallActivityEntity
import com.enjay.crm.callsync.data.local.SyncMetadataEntity
import com.enjay.crm.callsync.data.local.SyncState
import com.enjay.crm.callsync.data.model.CallType
import com.enjay.crm.callsync.data.repository.SyncMetadataRepository
import com.enjay.crm.callsync.util.PhoneNumberNormalizer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException

class DefaultSyncRepository(
    private val database: AppDatabase,
    private val syncApi: SyncApi,
    private val syncMetadataRepository: SyncMetadataRepository,
    private val deviceIdProvider: () -> String,
) : SyncRepository {

    private val currentDeviceId: String
        get() = deviceIdProvider()

    override fun observeSyncCursorState(): Flow<SyncCursorState?> {
        return syncMetadataRepository.observeSyncMetadata().map { metadata ->
            metadata?.toCursorState()
        }
    }

    override suspend fun runSync(): Pair<PushResultDto, PullResultDto> {
        val metadata = ensureMetadata()
        updateSyncStatus(metadata, status = STATUS_RUNNING, error = null, startedAt = System.currentTimeMillis())
        return try {
            val pushResult = pushPendingChanges(metadata)
            val pullResult = pullRemoteChanges()
            val completed = syncMetadataRepository.getSyncMetadata()?.copy(
                lastSyncCompletedAt = System.currentTimeMillis(),
                lastSyncStatus = STATUS_SUCCESS,
                lastSyncError = null,
                lastSuccessfulCursor = pullResult.nextCursor ?: syncMetadataRepository.getSyncMetadata()?.lastSuccessfulCursor,
            )
            if (completed != null) syncMetadataRepository.upsertSyncMetadata(completed)
            pushResult to pullResult
        } catch (exception: Exception) {
            val failed = syncMetadataRepository.getSyncMetadata()?.copy(
                lastSyncCompletedAt = System.currentTimeMillis(),
                lastSyncStatus = STATUS_FAILED,
                lastSyncError = exception.message,
            )
            if (failed != null) syncMetadataRepository.upsertSyncMetadata(failed)
            throw exception
        }
    }

    private suspend fun ensureMetadata(): SyncMetadataEntity {
        return syncMetadataRepository.getSyncMetadata() ?: SyncMetadataEntity(
            deviceId = deviceIdProvider(),
            lastSuccessfulCursor = null,
            lastSyncStartedAt = null,
            lastSyncCompletedAt = null,
            lastSyncStatus = STATUS_IDLE,
            lastSyncError = null,
        ).also { syncMetadataRepository.upsertSyncMetadata(it) }
    }

    private suspend fun updateSyncStatus(
        metadata: SyncMetadataEntity,
        status: String,
        error: String?,
        startedAt: Long? = metadata.lastSyncStartedAt,
    ) {
        syncMetadataRepository.upsertSyncMetadata(
            metadata.copy(
                lastSyncStartedAt = startedAt,
                lastSyncStatus = status,
                lastSyncError = error,
            ),
        )
    }

    private suspend fun pushPendingChanges(metadata: SyncMetadataEntity): PushResultDto {
        var syncedCount = 0
        var retryableFailures = 0
        var permanentFailures = 0

        repeat(MAX_PUSH_BATCHES) {
            val leads = database.leadDao().getPendingLeads(BATCH_SIZE)
            val callLogs = database.leadCallLogDao().getPendingLeadCallLogs(BATCH_SIZE)
            val activities = database.postCallActivityDao().getPendingPostCallActivities(BATCH_SIZE)
            if (leads.isEmpty() && callLogs.isEmpty() && activities.isEmpty()) {
                return PushResultDto(syncedCount, retryableFailures, permanentFailures)
            }

            val now = System.currentTimeMillis()
            database.withTransaction {
                leads.forEach { database.leadDao().updateLead(it.copy(lastSyncAttemptAt = now, syncError = null)) }
                callLogs.forEach { database.leadCallLogDao().updateLeadCallLog(it.copy(lastSyncAttemptAt = now, syncError = null)) }
                activities.forEach { database.postCallActivityDao().updatePostCallActivity(it.copy(lastSyncAttemptAt = now, syncError = null)) }
            }

            val leadPushRecords = leads.map { toLeadPushDto(it) }
            val callLogPushRecords = buildList {
                callLogs.forEach { callLog ->
                    toLeadCallLogPushDto(callLog)?.let(::add)
                }
            }
            val postCallPushRecords = buildList {
                activities.forEach { activity ->
                    toPostCallActivityPushDto(activity)?.let(::add)
                }
            }

            val request = PushRequestDto(
                deviceId = metadata.deviceId,
                appVersion = APP_VERSION,
                baseCursor = metadata.lastSuccessfulCursor,
                records = PushRecordsDto(
                    leads = leadPushRecords,
                    leadCallLogs = callLogPushRecords,
                    postCallActivities = postCallPushRecords,
                ),
            )

            val response = try {
                syncApi.push(request)
            } catch (exception: IOException) {
                markRetryable(leads, callLogs, activities, exception.message)
                throw exception
            } catch (exception: HttpException) {
                if (exception.code() >= 500) {
                    markRetryable(leads, callLogs, activities, exception.message())
                }
                throw exception
            }

            database.withTransaction {
                response.results.leads.forEach { result ->
                    val localId = result.clientRecordId.toLongOrNull() ?: return@forEach
                    val current = database.leadDao().getLeadById(localId) ?: return@forEach
                    val updated = applyPushResult(current, result)
                    database.leadDao().updateLead(updated)
                    if (updated.syncState == SyncState.SYNCED) syncedCount++ else if (updated.syncState == SyncState.FAILED_PERMANENT) permanentFailures++
                }
                response.results.leadCallLogs.forEach { result ->
                    val localId = result.clientRecordId.toLongOrNull() ?: return@forEach
                    val current = database.leadCallLogDao().getById(localId) ?: return@forEach
                    val updated = applyPushResult(current, result)
                    database.leadCallLogDao().updateLeadCallLog(updated)
                    if (updated.syncState == SyncState.SYNCED) syncedCount++ else if (updated.syncState == SyncState.FAILED_PERMANENT) permanentFailures++
                }
                response.results.postCallActivities.forEach { result ->
                    val localId = result.clientRecordId.toLongOrNull() ?: return@forEach
                    val current = database.postCallActivityDao().getById(localId) ?: return@forEach
                    val updated = applyPushResult(current, result)
                    database.postCallActivityDao().updatePostCallActivity(updated)
                    if (updated.syncState == SyncState.SYNCED) syncedCount++ else if (updated.syncState == SyncState.FAILED_PERMANENT) permanentFailures++
                }
            }
        }
        return PushResultDto(syncedCount, retryableFailures, permanentFailures)
    }

    private suspend fun pullRemoteChanges(): PullResultDto {
        val metadata = ensureMetadata()
        var cursor = metadata.lastSuccessfulCursor
        var appliedCount = 0

        repeat(MAX_PULL_BATCHES) {
            val response = syncApi.pull(
                PullRequestDto(
                    deviceId = metadata.deviceId,
                    sinceCursor = cursor,
                    limit = PULL_LIMIT,
                    entityTypes = ENTITY_TYPES,
                ),
            )
            database.withTransaction {
                response.records.leads.forEach { appliedCount += applyLeadPull(it) }
                response.records.leadCallLogs.forEach { appliedCount += applyLeadCallLogPull(it) }
                response.records.postCallActivities.forEach { appliedCount += applyPostCallActivityPull(it) }
            }
            cursor = response.nextCursor ?: cursor
            if (!response.hasMore) {
                return PullResultDto(appliedCount, cursor)
            }
        }

        return PullResultDto(appliedCount, cursor)
    }

    private suspend fun markRetryable(
        leads: List<LeadEntity>,
        callLogs: List<LeadCallLogEntity>,
        activities: List<PostCallActivityEntity>,
        message: String?,
    ) {
        database.withTransaction {
            leads.forEach {
                database.leadDao().updateLead(it.copy(syncState = SyncState.FAILED_RETRYABLE, syncError = message))
            }
            callLogs.forEach {
                database.leadCallLogDao().updateLeadCallLog(it.copy(syncState = SyncState.FAILED_RETRYABLE, syncError = message))
            }
            activities.forEach {
                database.postCallActivityDao().updatePostCallActivity(it.copy(syncState = SyncState.FAILED_RETRYABLE, syncError = message))
            }
        }
    }

    private suspend fun applyLeadPull(remote: LeadPullDto): Int {
        val localSourceId = remote.localSourceIdForThisDevice()
        val localByIdentity = database.leadDao().findByServerId(remote.id)
            ?: localSourceId?.let { database.leadDao().getLeadById(it) }
            ?: database.leadDao().findByExternalId(remote.id)
        val localByPhone = findLocalLeadByPhone(remote.phone)
        val local = consolidateLeadIfNeeded(
            remoteLeadId = remote.id,
            localByIdentity = localByIdentity,
            localByPhone = localByPhone,
        ) ?: localByIdentity ?: localByPhone
        val remoteUpdatedAt = SyncDateCodec.fromIso(remote.updatedAt) ?: return 0
        val remoteCreatedAt = SyncDateCodec.fromIso(remote.createdAt) ?: remoteUpdatedAt
        val localPhoneLookupKeys = remote.phoneLookupKeys?.takeIf { it.isNotEmpty() }?.toLookupKeyBlob()
            ?: PhoneNumberNormalizer.lookupKeyBlob(remote.phone)

        if (local == null) {
            val insertedId = database.leadDao().insertLead(
                LeadEntity(
                    id = localSourceId ?: 0L,
                    externalId = localSourceId?.let { "lead-$it" } ?: "remote-lead-${remote.id}",
                    serverId = remote.id,
                    syncState = SyncState.SYNCED,
                    lastSyncAttemptAt = null,
                    lastSyncedAt = System.currentTimeMillis(),
                    syncError = null,
                    deletedAt = SyncDateCodec.fromIso(remote.deletedAt),
                    name = remote.name,
                    phone = remote.phone,
                    phoneLookupKeys = localPhoneLookupKeys,
                    createdAt = remoteCreatedAt,
                    updatedAt = remoteUpdatedAt,
                ),
            )
            if (insertedId > 0L && remote.sourceRecordId == null) {
                database.leadDao().updateLead(
                    requireNotNull(database.leadDao().getLeadById(insertedId)).copy(externalId = "lead-$insertedId"),
                )
            }
            return 1
        }

        if (local.syncState != SyncState.SYNCED && local.updatedAt > remoteUpdatedAt) return 0

        database.leadDao().updateLead(
            local.copy(
                serverId = remote.id,
                syncState = SyncState.SYNCED,
                lastSyncedAt = System.currentTimeMillis(),
                syncError = null,
                deletedAt = SyncDateCodec.fromIso(remote.deletedAt),
                name = remote.name,
                phone = remote.phone,
                phoneLookupKeys = localPhoneLookupKeys,
                createdAt = remoteCreatedAt,
                updatedAt = remoteUpdatedAt,
            ),
        )
        return 1
    }

    private suspend fun findLocalLeadByPhone(phoneNumber: String): LeadEntity? {
        val lookupKeys = PhoneNumberNormalizer.lookupKeys(phoneNumber)
        if (lookupKeys.isEmpty()) return null

        fun String.asWrappedToken(): String = "|$this|"

        lookupKeys.forEach { key ->
            database.leadDao().findLeadByLookupKey(key.asWrappedToken())?.let { return it }
        }
        return null
    }

    private suspend fun consolidateLeadIfNeeded(
        remoteLeadId: String,
        localByIdentity: LeadEntity?,
        localByPhone: LeadEntity?,
    ): LeadEntity? {
        if (localByIdentity == null || localByPhone == null || localByIdentity.id == localByPhone.id) {
            return null
        }

        val canonical = if (localByPhone.serverId == null || localByPhone.serverId == remoteLeadId) {
            localByPhone
        } else {
            localByIdentity
        }
        val duplicate = if (canonical.id == localByIdentity.id) localByPhone else localByIdentity

        database.leadCallLogDao().reassignLead(fromLeadId = duplicate.id, toLeadId = canonical.id)
        database.postCallActivityDao().reassignLead(fromLeadId = duplicate.id, toLeadId = canonical.id)
        database.leadDao().deleteLeadById(duplicate.id)

        return canonical
    }

    private suspend fun applyLeadCallLogPull(remote: LeadCallLogPullDto): Int {
        val lead = database.leadDao().findByServerId(remote.leadId) ?: database.leadDao().findByExternalId(remote.leadId) ?: return 0
        val localSourceId = remote.localSourceIdForThisDevice()
        val local = database.leadCallLogDao().findByServerId(remote.id)
            ?: localSourceId?.let { database.leadCallLogDao().getById(it) }
            ?: database.leadCallLogDao().findByExternalId(remote.id)
        val remoteUpdatedAt = SyncDateCodec.fromIso(remote.updatedAt) ?: return 0
        val remoteCreatedAt = SyncDateCodec.fromIso(remote.createdAt) ?: remoteUpdatedAt
        val entity = LeadCallLogEntity(
            id = local?.id ?: (localSourceId ?: 0L),
            externalId = local?.externalId
                ?: localSourceId?.let { "call-${remote.deviceCallLogId}" }
                ?: "remote-call-${remote.id}",
            serverId = remote.id,
            syncState = SyncState.SYNCED,
            lastSyncAttemptAt = local?.lastSyncAttemptAt,
            lastSyncedAt = System.currentTimeMillis(),
            syncError = null,
            deletedAt = SyncDateCodec.fromIso(remote.deletedAt),
            leadId = lead.id,
            deviceCallLogId = remote.deviceCallLogId.toLongOrNull() ?: return 0,
            phoneNumber = remote.phoneNumber,
            callType = CallType.valueOf(remote.callType),
            startTime = SyncDateCodec.fromIso(remote.startTime) ?: return 0,
            endTime = SyncDateCodec.fromIso(remote.endTime) ?: return 0,
            durationSeconds = remote.durationSeconds,
            timestamp = SyncDateCodec.fromIso(remote.timestamp) ?: return 0,
            createdAt = remoteCreatedAt,
            updatedAt = remoteUpdatedAt,
        )
        if (local == null) {
            database.leadCallLogDao().insertLeadCallLog(entity)
        } else if (local.syncState == SyncState.SYNCED || local.updatedAt <= remoteUpdatedAt) {
            database.leadCallLogDao().updateLeadCallLog(entity)
        }
        return 1
    }

    private suspend fun applyPostCallActivityPull(remote: PostCallActivityPullDto): Int {
        val lead = database.leadDao().findByServerId(remote.leadId) ?: database.leadDao().findByExternalId(remote.leadId) ?: return 0
        val callLog = database.leadCallLogDao().findByServerId(remote.leadCallLogId)
            ?: database.leadCallLogDao().findByExternalId(remote.leadCallLogId)
            ?: return 0
        val localSourceId = remote.localSourceIdForThisDevice()
        val local = database.postCallActivityDao().findByServerId(remote.id)
            ?: localSourceId?.let { database.postCallActivityDao().getById(it) }
            ?: database.postCallActivityDao().findByExternalId(remote.id)
        val remoteUpdatedAt = SyncDateCodec.fromIso(remote.updatedAt) ?: return 0
        val remoteCreatedAt = SyncDateCodec.fromIso(remote.createdAt) ?: remoteUpdatedAt
        val entity = PostCallActivityEntity(
            id = local?.id ?: (localSourceId ?: 0L),
            externalId = local?.externalId
                ?: localSourceId?.let { "activity-$it" }
                ?: "remote-activity-${remote.id}",
            serverId = remote.id,
            syncState = SyncState.SYNCED,
            lastSyncAttemptAt = local?.lastSyncAttemptAt,
            lastSyncedAt = System.currentTimeMillis(),
            syncError = null,
            deletedAt = SyncDateCodec.fromIso(remote.deletedAt),
            leadId = lead.id,
            leadCallLogId = callLog.id,
            callNotes = remote.callNotes,
            callOutcome = remote.callOutcome,
            followUpAt = SyncDateCodec.fromIso(remote.followUpAt) ?: return 0,
            nextAction = remote.nextAction,
            additionalRemarks = remote.additionalRemarks,
            createdAt = remoteCreatedAt,
            updatedAt = remoteUpdatedAt,
        )
        if (local == null) {
            val insertedId = database.postCallActivityDao().insertPostCallActivity(entity)
            if (insertedId > 0L && entity.externalId.isBlank()) {
                database.postCallActivityDao().updatePostCallActivity(
                    requireNotNull(database.postCallActivityDao().getById(insertedId)).copy(externalId = "activity-$insertedId"),
                )
            }
        } else if (local.syncState == SyncState.SYNCED || local.updatedAt <= remoteUpdatedAt) {
            database.postCallActivityDao().updatePostCallActivity(entity)
        }
        return 1
    }

    private suspend fun toLeadCallLogPushDto(callLog: LeadCallLogEntity): LeadCallLogPushDto? {
        val lead = database.leadDao().getLeadById(callLog.leadId) ?: return null
        return LeadCallLogPushDto(
            id = callLog.serverId,
            externalId = callLog.externalId,
            sourceRecordId = callLog.id.toString(),
            createdAt = SyncDateCodec.toIso(callLog.createdAt) ?: return null,
            updatedAt = SyncDateCodec.toIso(callLog.updatedAt) ?: return null,
            deletedAt = SyncDateCodec.toIso(callLog.deletedAt),
            source = SOURCE_ANDROID,
            leadId = lead.serverId ?: lead.externalId,
            deviceCallLogId = callLog.deviceCallLogId.toString(),
            phoneNumber = callLog.phoneNumber,
            callType = callLog.callType.name,
            startTime = SyncDateCodec.toIso(callLog.startTime) ?: return null,
            endTime = SyncDateCodec.toIso(callLog.endTime) ?: return null,
            durationSeconds = callLog.durationSeconds,
            timestamp = SyncDateCodec.toIso(callLog.timestamp) ?: return null,
        )
    }

    private suspend fun toPostCallActivityPushDto(activity: PostCallActivityEntity): PostCallActivityPushDto? {
        val lead = database.leadDao().getLeadById(activity.leadId) ?: return null
        val callLog = database.leadCallLogDao().getById(activity.leadCallLogId) ?: return null
        return PostCallActivityPushDto(
            id = activity.serverId,
            externalId = activity.externalId,
            sourceRecordId = activity.id.toString(),
            createdAt = SyncDateCodec.toIso(activity.createdAt) ?: return null,
            updatedAt = SyncDateCodec.toIso(activity.updatedAt) ?: return null,
            deletedAt = SyncDateCodec.toIso(activity.deletedAt),
            source = SOURCE_ANDROID,
            leadId = lead.serverId ?: lead.externalId,
            leadCallLogId = callLog.serverId ?: callLog.externalId,
            callNotes = activity.callNotes,
            callOutcome = activity.callOutcome,
            followUpAt = SyncDateCodec.toIso(activity.followUpAt) ?: return null,
            nextAction = activity.nextAction,
            additionalRemarks = activity.additionalRemarks,
        )
    }

    private fun toLeadPushDto(lead: LeadEntity): LeadPushDto {
        return LeadPushDto(
            id = lead.serverId,
            externalId = lead.externalId,
            sourceRecordId = lead.id.toString(),
            createdAt = requireNotNull(SyncDateCodec.toIso(lead.createdAt)),
            updatedAt = requireNotNull(SyncDateCodec.toIso(lead.updatedAt)),
            deletedAt = SyncDateCodec.toIso(lead.deletedAt),
            source = SOURCE_ANDROID,
            name = lead.name,
            phone = lead.phone,
        )
    }

    private fun applyPushResult(current: LeadEntity, result: PushResultItemDto): LeadEntity {
        val nextState = when (result.action) {
            "inserted", "updated", "skipped", "duplicate", "conflict_ignored" -> SyncState.SYNCED
            "rejected" -> SyncState.FAILED_PERMANENT
            else -> SyncState.FAILED_RETRYABLE
        }
        return current.copy(
            serverId = result.serverRecordId ?: current.serverId,
            syncState = nextState,
            lastSyncedAt = SyncDateCodec.fromIso(result.serverUpdatedAt) ?: System.currentTimeMillis(),
            syncError = result.message,
            updatedAt = SyncDateCodec.fromIso(result.serverUpdatedAt) ?: current.updatedAt,
        )
    }

    private fun applyPushResult(current: LeadCallLogEntity, result: PushResultItemDto): LeadCallLogEntity {
        val nextState = when (result.action) {
            "inserted", "updated", "skipped", "duplicate", "conflict_ignored" -> SyncState.SYNCED
            "rejected" -> SyncState.FAILED_PERMANENT
            else -> SyncState.FAILED_RETRYABLE
        }
        return current.copy(
            serverId = result.serverRecordId ?: current.serverId,
            syncState = nextState,
            lastSyncedAt = SyncDateCodec.fromIso(result.serverUpdatedAt) ?: System.currentTimeMillis(),
            syncError = result.message,
            createdAt = current.createdAt,
            updatedAt = SyncDateCodec.fromIso(result.serverUpdatedAt) ?: current.updatedAt,
        )
    }

    private fun applyPushResult(current: PostCallActivityEntity, result: PushResultItemDto): PostCallActivityEntity {
        val nextState = when (result.action) {
            "inserted", "updated", "skipped", "duplicate", "conflict_ignored" -> SyncState.SYNCED
            "rejected" -> SyncState.FAILED_PERMANENT
            else -> SyncState.FAILED_RETRYABLE
        }
        return current.copy(
            serverId = result.serverRecordId ?: current.serverId,
            syncState = nextState,
            lastSyncedAt = SyncDateCodec.fromIso(result.serverUpdatedAt) ?: System.currentTimeMillis(),
            syncError = result.message,
            updatedAt = SyncDateCodec.fromIso(result.serverUpdatedAt) ?: current.updatedAt,
        )
    }

    private fun SyncMetadataEntity.toCursorState() = SyncCursorState(
        deviceId = deviceId,
        lastSuccessfulCursor = lastSuccessfulCursor,
        lastSyncStartedAt = lastSyncStartedAt,
        lastSyncCompletedAt = lastSyncCompletedAt,
        lastSyncStatus = lastSyncStatus,
        lastSyncError = lastSyncError,
    )

    private fun List<String>.toLookupKeyBlob(): String {
        return if (isEmpty()) "" else "|${sorted().joinToString("|")}|"
    }

    private fun LeadPullDto.localSourceIdForThisDevice(): Long? {
        return if (sourceDeviceId == currentDeviceId) sourceRecordId?.toLongOrNull() else null
    }

    private fun LeadCallLogPullDto.localSourceIdForThisDevice(): Long? {
        return if (sourceDeviceId == currentDeviceId) sourceRecordId?.toLongOrNull() else null
    }

    private fun PostCallActivityPullDto.localSourceIdForThisDevice(): Long? {
        return if (sourceDeviceId == currentDeviceId) sourceRecordId?.toLongOrNull() else null
    }

    companion object {
        private const val BATCH_SIZE = 50
        private const val APP_VERSION = "1.0"
        private const val PULL_LIMIT = 100
        private const val MAX_PUSH_BATCHES = 10
        private const val MAX_PULL_BATCHES = 10
        private const val SOURCE_ANDROID = "android"
        private const val STATUS_IDLE = "IDLE"
        private const val STATUS_RUNNING = "RUNNING"
        private const val STATUS_SUCCESS = "SUCCESS"
        private const val STATUS_FAILED = "FAILED"
        private val ENTITY_TYPES = listOf("leads", "leadCallLogs", "postCallActivities")
    }
}
