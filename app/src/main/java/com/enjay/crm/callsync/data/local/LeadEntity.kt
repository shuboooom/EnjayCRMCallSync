package com.enjay.crm.callsync.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "leads")
data class LeadEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val phone: String,
    val phoneLookupKeys: String,
    val createdAt: Long,
    val updatedAt: Long,
)
