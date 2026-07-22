package com.enjay.crm.callsync.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LeadDao {
    @Query("SELECT * FROM leads ORDER BY createdAt DESC")
    fun observeLeads(): Flow<List<LeadEntity>>

    @Query("SELECT * FROM leads WHERE id = :leadId LIMIT 1")
    fun observeLeadById(leadId: Long): Flow<LeadEntity?>

    @Query("SELECT * FROM leads WHERE id = :leadId LIMIT 1")
    suspend fun getLeadById(leadId: Long): LeadEntity?

    @Query("SELECT * FROM leads")
    suspend fun getAllLeads(): List<LeadEntity>

    @Query("SELECT * FROM leads WHERE phoneLookupKeys LIKE '%' || :wrappedLookupKey || '%' LIMIT 1")
    suspend fun findLeadByLookupKey(wrappedLookupKey: String): LeadEntity?

    @Query("UPDATE leads SET phoneLookupKeys = :phoneLookupKeys, updatedAt = :updatedAt WHERE id = :leadId")
    suspend fun updateLookupKeys(leadId: Long, phoneLookupKeys: String, updatedAt: Long)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLead(lead: LeadEntity): Long
}
