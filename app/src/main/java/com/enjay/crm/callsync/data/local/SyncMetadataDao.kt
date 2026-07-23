package com.enjay.crm.callsync.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SyncMetadataDao {
    @Query("SELECT * FROM sync_metadata WHERE id = :id LIMIT 1")
    fun observeById(id: Int = SyncMetadataEntity.SINGLETON_ID): Flow<SyncMetadataEntity?>

    @Query("SELECT * FROM sync_metadata WHERE id = :id LIMIT 1")
    suspend fun getById(id: Int = SyncMetadataEntity.SINGLETON_ID): SyncMetadataEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(metadata: SyncMetadataEntity)
}
