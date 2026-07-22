package com.enjay.crm.callsync.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LeadCallLogDao {
    @Query("SELECT * FROM lead_call_logs WHERE leadId = :leadId ORDER BY timestamp DESC")
    fun observeLeadCallLogs(leadId: Long): Flow<List<LeadCallLogEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLeadCallLog(callLog: LeadCallLogEntity): Long
}
