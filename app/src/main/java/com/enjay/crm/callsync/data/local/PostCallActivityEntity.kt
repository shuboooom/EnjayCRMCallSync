package com.enjay.crm.callsync.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "post_call_activities",
    foreignKeys = [
        ForeignKey(
            entity = LeadEntity::class,
            parentColumns = ["id"],
            childColumns = ["leadId"],
            onDelete = ForeignKey.CASCADE,
        ),
        ForeignKey(
            entity = LeadCallLogEntity::class,
            parentColumns = ["id"],
            childColumns = ["leadCallLogId"],
            onDelete = ForeignKey.CASCADE,
        ),
    ],
    indices = [
        Index(value = ["leadId"]),
        Index(value = ["leadCallLogId"]),
        Index(value = ["externalId"], unique = true),
        Index(value = ["serverId"], unique = true),
    ],
)
data class PostCallActivityEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val externalId: String,
    val serverId: String?,
    val syncState: SyncState,
    val lastSyncAttemptAt: Long?,
    val lastSyncedAt: Long?,
    val syncError: String?,
    val deletedAt: Long?,
    val leadId: Long,
    val leadCallLogId: Long,
    val callNotes: String,
    val callOutcome: String,
    val followUpAt: Long,
    val nextAction: String,
    val additionalRemarks: String?,
    val createdAt: Long,
    val updatedAt: Long,
)
