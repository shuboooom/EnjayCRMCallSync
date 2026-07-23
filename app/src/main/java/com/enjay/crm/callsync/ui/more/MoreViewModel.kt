package com.enjay.crm.callsync.ui.more

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.enjay.crm.callsync.EnjayCallSyncApp
import com.enjay.crm.callsync.data.sync.SyncCursorState
import com.enjay.crm.callsync.data.sync.SyncRepository
import com.enjay.crm.callsync.sync.SyncWorkScheduler
import com.enjay.crm.callsync.sync.SyncWorker
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

data class MoreUiState(
    val syncState: SyncCursorState? = null,
    val workDebugState: SyncWorkDebugState = SyncWorkDebugState(),
    val pendingSyncCounts: PendingSyncCounts = PendingSyncCounts(),
)

data class PendingSyncCounts(
    val leads: Int = 0,
    val callLogs: Int = 0,
    val postCallActivities: Int = 0,
)

data class SyncWorkDebugState(
    val workerType: String? = null,
    val workerState: String? = null,
    val retryAttempt: Int = 0,
    val reason: String? = null,
    val isSyncRunning: Boolean = false,
)

class MoreViewModel(
    application: Application,
    syncRepository: SyncRepository,
) : ViewModel() {

    private val workManager = WorkManager.getInstance(application)
    private val database = (application as EnjayCallSyncApp).appContainer.database
    private val pendingSyncCountsFlow = combine(
        database.leadDao().observePendingLeadCount(),
        database.leadCallLogDao().observePendingLeadCallLogCount(),
        database.postCallActivityDao().observePendingPostCallActivityCount(),
    ) { pendingLeadCount, pendingLeadCallLogCount, pendingPostCallActivityCount ->
        PendingSyncCounts(
            leads = pendingLeadCount,
            callLogs = pendingLeadCallLogCount,
            postCallActivities = pendingPostCallActivityCount,
        )
    }

    val uiState: StateFlow<MoreUiState> = combine(
        syncRepository.observeSyncCursorState(),
        pendingSyncCountsFlow,
        workManager.getWorkInfosForUniqueWorkLiveData(SyncWorkScheduler.IMMEDIATE_SYNC_WORK_NAME).asFlow(),
        workManager.getWorkInfosForUniqueWorkLiveData(SyncWorkScheduler.PERIODIC_SYNC_WORK_NAME).asFlow(),
    ) { syncState, pendingSyncCounts, immediateWorkInfos, periodicWorkInfos ->
        MoreUiState(
            syncState = syncState,
            pendingSyncCounts = pendingSyncCounts,
            workDebugState = selectWorkDebugState(immediateWorkInfos, periodicWorkInfos),
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), MoreUiState())

    private fun selectWorkDebugState(
        immediateWorkInfos: List<WorkInfo>,
        periodicWorkInfos: List<WorkInfo>,
    ): SyncWorkDebugState {
        val isSyncRunning = immediateWorkInfos.any { it.state == WorkInfo.State.RUNNING } ||
            periodicWorkInfos.any { it.state == WorkInfo.State.RUNNING }
        val immediateActive = immediateWorkInfos.bestCandidate()
        val periodicActive = periodicWorkInfos.bestCandidate()
        val selected = listOfNotNull(immediateActive, periodicActive)
            .sortedBy { info -> info.state.priority }
            .firstOrNull()

        return when {
            selected == null -> SyncWorkDebugState(isSyncRunning = isSyncRunning)
            selected === immediateActive -> selected.toDebugState(workerType = "Immediate", isSyncRunning = isSyncRunning)
            else -> selected.toDebugState(workerType = "Periodic", isSyncRunning = isSyncRunning)
        }
    }

    private fun List<WorkInfo>.bestCandidate(): WorkInfo? {
        return sortedBy { workInfo -> workInfo.state.priority }
            .firstOrNull()
    }

    private fun WorkInfo.toDebugState(workerType: String, isSyncRunning: Boolean): SyncWorkDebugState {
        return SyncWorkDebugState(
            workerType = workerType,
            workerState = state.name.replace('_', ' '),
            retryAttempt = runAttemptCount.coerceAtMost(SyncWorker.MAX_RETRY_ATTEMPTS),
            reason = outputData.getString(SyncWorkScheduler.KEY_REASON)
                ?: progress.getString(SyncWorkScheduler.KEY_REASON)
                ?: tags.firstOrNull { it.startsWith("reason:") }?.removePrefix("reason:")
                ?: if (workerType == "Periodic") "scheduled_15m" else null,
            isSyncRunning = isSyncRunning,
        )
    }

    private val WorkInfo.State.priority: Int
        get() = when (this) {
            WorkInfo.State.RUNNING -> 0
            WorkInfo.State.ENQUEUED -> 1
            WorkInfo.State.BLOCKED -> 2
            WorkInfo.State.SUCCEEDED -> 3
            WorkInfo.State.FAILED -> 4
            WorkInfo.State.CANCELLED -> 5
        }
}
