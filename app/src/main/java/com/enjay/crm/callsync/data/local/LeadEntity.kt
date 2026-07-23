package com.enjay.crm.callsync.data.local

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "leads",
    indices = [
        Index(value = ["externalId"], unique = true),
        Index(value = ["serverId"], unique = true),
    ],
)
data class LeadEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val externalId: String,
    val serverId: String?,
    val syncState: SyncState,
    val lastSyncAttemptAt: Long?,
    val lastSyncedAt: Long?,
    val syncError: String?,
    val deletedAt: Long?,
    val name: String,
    val phone: String,
    val phoneLookupKeys: String,
    val createdAt: Long,
    val updatedAt: Long,
)
