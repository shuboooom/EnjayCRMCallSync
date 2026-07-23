package com.enjay.crm.callsync.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface LeadCallLogDao {
    @Query("SELECT * FROM lead_call_logs WHERE leadId = :leadId ORDER BY timestamp DESC")
    fun observeLeadCallLogs(leadId: Long): Flow<List<LeadCallLogEntity>>

    @Query("SELECT * FROM lead_call_logs WHERE syncState != 'SYNCED' ORDER BY timestamp ASC LIMIT :limit")
    suspend fun getPendingLeadCallLogs(limit: Int): List<LeadCallLogEntity>

    @Query("SELECT COUNT(*) FROM lead_call_logs WHERE syncState != 'SYNCED'")
    fun observePendingLeadCallLogCount(): Flow<Int>

    @Query("SELECT * FROM lead_call_logs WHERE id = :id LIMIT 1")
    suspend fun getById(id: Long): LeadCallLogEntity?

    @Query("SELECT * FROM lead_call_logs WHERE serverId = :serverId LIMIT 1")
    suspend fun findByServerId(serverId: String): LeadCallLogEntity?

    @Query("SELECT * FROM lead_call_logs WHERE externalId = :externalId LIMIT 1")
    suspend fun findByExternalId(externalId: String): LeadCallLogEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLeadCallLog(callLog: LeadCallLogEntity): Long

    @Update
    suspend fun updateLeadCallLog(callLog: LeadCallLogEntity)

    @Query("UPDATE lead_call_logs SET leadId = :toLeadId WHERE leadId = :fromLeadId")
    suspend fun reassignLead(fromLeadId: Long, toLeadId: Long)
}
