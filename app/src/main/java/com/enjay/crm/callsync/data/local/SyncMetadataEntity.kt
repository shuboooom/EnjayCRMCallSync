package com.enjay.crm.callsync.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sync_metadata")
data class SyncMetadataEntity(
    @PrimaryKey val id: Int = SINGLETON_ID,
    val deviceId: String,
    val lastSuccessfulCursor: String?,
    val lastSyncStartedAt: Long?,
    val lastSyncCompletedAt: Long?,
    val lastSyncStatus: String?,
    val lastSyncError: String?,
) {
    companion object {
        const val SINGLETON_ID = 0
    }
}
