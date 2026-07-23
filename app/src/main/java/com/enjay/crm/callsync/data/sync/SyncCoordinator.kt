package com.enjay.crm.callsync.data.sync

import kotlinx.coroutines.sync.Mutex

class SyncCoordinator(
    private val syncRepository: SyncRepository,
) {
    private val mutex = Mutex()

    suspend fun runSync(): SyncRunOutcome {
        if (!mutex.tryLock()) {
            return SyncRunOutcome.AlreadyRunning
        }
        return try {
            SyncRunOutcome.Completed(syncRepository.runSync())
        } finally {
            mutex.unlock()
        }
    }
}

sealed interface SyncRunOutcome {
    data class Completed(val result: Pair<PushResultDto, PullResultDto>) : SyncRunOutcome
    data object AlreadyRunning : SyncRunOutcome
}
