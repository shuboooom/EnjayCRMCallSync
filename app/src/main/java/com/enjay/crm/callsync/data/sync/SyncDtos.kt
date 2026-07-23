package com.enjay.crm.callsync.data.sync

data class PushRequestDto(
    val deviceId: String,
    val appVersion: String,
    val baseCursor: String?,
    val records: PushRecordsDto,
)

data class PushRecordsDto(
    val leads: List<LeadPushDto>,
    val leadCallLogs: List<LeadCallLogPushDto>,
    val postCallActivities: List<PostCallActivityPushDto>,
)

data class LeadPushDto(
    val id: String?,
    val externalId: String,
    val sourceRecordId: String,
    val createdAt: String,
    val updatedAt: String,
    val deletedAt: String?,
    val source: String,
    val name: String,
    val phone: String,
)

data class LeadCallLogPushDto(
    val id: String?,
    val externalId: String,
    val sourceRecordId: String,
    val createdAt: String,
    val updatedAt: String,
    val deletedAt: String?,
    val source: String,
    val leadId: String,
    val deviceCallLogId: String,
    val phoneNumber: String,
    val callType: String,
    val startTime: String,
    val endTime: String,
    val durationSeconds: Long,
    val timestamp: String,
)

data class PostCallActivityPushDto(
    val id: String?,
    val externalId: String,
    val sourceRecordId: String,
    val createdAt: String,
    val updatedAt: String,
    val deletedAt: String?,
    val source: String,
    val leadId: String,
    val leadCallLogId: String,
    val callNotes: String,
    val callOutcome: String,
    val followUpAt: String,
    val nextAction: String,
    val additionalRemarks: String?,
)

data class PushResponseDto(
    val success: Boolean,
    val serverCursor: String?,
    val results: PushResultsDto,
)

data class PushResultsDto(
    val leads: List<PushResultItemDto>,
    val leadCallLogs: List<PushResultItemDto>,
    val postCallActivities: List<PushResultItemDto>,
)

data class PushResultItemDto(
    val clientRecordId: String,
    val serverRecordId: String?,
    val action: String,
    val message: String?,
    val serverUpdatedAt: String?,
)

data class PullRequestDto(
    val deviceId: String,
    val sinceCursor: String?,
    val limit: Int,
    val entityTypes: List<String>,
)

data class PullResponseDto(
    val success: Boolean,
    val nextCursor: String?,
    val hasMore: Boolean,
    val records: PullRecordsDto,
)

data class PullRecordsDto(
    val leads: List<LeadPullDto>,
    val leadCallLogs: List<LeadCallLogPullDto>,
    val postCallActivities: List<PostCallActivityPullDto>,
)

data class LeadPullDto(
    val id: String,
    val source: String?,
    val sourceDeviceId: String?,
    val sourceRecordId: String?,
    val createdAt: String,
    val updatedAt: String,
    val deletedAt: String?,
    val name: String,
    val phone: String,
    val phoneLookupKeys: List<String>?,
)

data class LeadCallLogPullDto(
    val id: String,
    val source: String?,
    val sourceDeviceId: String?,
    val sourceRecordId: String?,
    val createdAt: String,
    val updatedAt: String,
    val deletedAt: String?,
    val leadId: String,
    val deviceCallLogId: String,
    val phoneNumber: String,
    val callType: String,
    val startTime: String,
    val endTime: String,
    val durationSeconds: Long,
    val timestamp: String,
)

data class PostCallActivityPullDto(
    val id: String,
    val source: String?,
    val sourceDeviceId: String?,
    val sourceRecordId: String?,
    val createdAt: String,
    val updatedAt: String,
    val deletedAt: String?,
    val leadId: String,
    val leadCallLogId: String,
    val callNotes: String,
    val callOutcome: String,
    val followUpAt: String,
    val nextAction: String,
    val additionalRemarks: String?,
)

data class PushResultDto(
    val syncedCount: Int,
    val retryableFailures: Int,
    val permanentFailures: Int,
)

data class PullResultDto(
    val appliedCount: Int,
    val nextCursor: String?,
)

data class SyncCursorState(
    val deviceId: String,
    val lastSuccessfulCursor: String?,
    val lastSyncStartedAt: Long?,
    val lastSyncCompletedAt: Long?,
    val lastSyncStatus: String?,
    val lastSyncError: String?,
)
