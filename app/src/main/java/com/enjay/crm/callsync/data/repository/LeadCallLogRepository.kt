package com.enjay.crm.callsync.data.repository

import com.enjay.crm.callsync.data.local.LeadCallLogEntity
import kotlinx.coroutines.flow.Flow

interface LeadCallLogRepository {
    fun observeLeadCallLogs(leadId: Long): Flow<List<LeadCallLogEntity>>
    suspend fun addLeadCallLog(callLog: LeadCallLogEntity): Boolean
}
