package com.enjay.crm.callsync.data.sync

import kotlinx.coroutines.flow.Flow

interface SyncRepository {
    fun observeSyncCursorState(): Flow<SyncCursorState?>
    suspend fun runSync(): Pair<PushResultDto, PullResultDto>
}
