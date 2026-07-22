package com.enjay.crm.callsync.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.enjay.crm.callsync.data.model.CallType

@Entity(
    tableName = "lead_call_logs",
    foreignKeys = [
        ForeignKey(
            entity = LeadEntity::class,
            parentColumns = ["id"],
            childColumns = ["leadId"],
            onDelete = ForeignKey.CASCADE,
        ),
    ],
    indices = [
        Index(value = ["leadId"]),
        Index(value = ["deviceCallLogId"], unique = true),
    ],
)
data class LeadCallLogEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val leadId: Long,
    val deviceCallLogId: Long,
    val phoneNumber: String,
    val callType: CallType,
    val startTime: Long,
    val endTime: Long,
    val durationSeconds: Long,
    val timestamp: Long,
    val createdAt: Long,
)
