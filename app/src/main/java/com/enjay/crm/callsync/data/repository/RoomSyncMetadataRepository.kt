package com.enjay.crm.callsync.data.repository

import com.enjay.crm.callsync.data.local.SyncMetadataDao
import com.enjay.crm.callsync.data.local.SyncMetadataEntity

class RoomSyncMetadataRepository(
    private val syncMetadataDao: SyncMetadataDao,
) : SyncMetadataRepository {

    override fun observeSyncMetadata() = syncMetadataDao.observeById()

    override suspend fun getSyncMetadata(): SyncMetadataEntity? = syncMetadataDao.getById()

    override suspend fun upsertSyncMetadata(metadata: SyncMetadataEntity) {
        syncMetadataDao.upsert(metadata)
    }
}
