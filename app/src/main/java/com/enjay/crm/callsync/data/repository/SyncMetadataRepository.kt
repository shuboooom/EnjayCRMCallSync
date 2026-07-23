package com.enjay.crm.callsync.data.repository

import com.enjay.crm.callsync.data.local.SyncMetadataEntity
import kotlinx.coroutines.flow.Flow

interface SyncMetadataRepository {
    fun observeSyncMetadata(): Flow<SyncMetadataEntity?>
    suspend fun getSyncMetadata(): SyncMetadataEntity?
    suspend fun upsertSyncMetadata(metadata: SyncMetadataEntity)
}
