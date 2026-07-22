package com.enjay.crm.callsync.data.repository

import android.util.Log
import com.enjay.crm.callsync.data.local.LeadCallLogDao
import com.enjay.crm.callsync.data.local.LeadCallLogEntity
import kotlinx.coroutines.flow.Flow

class RoomLeadCallLogRepository(
    private val leadCallLogDao: LeadCallLogDao,
) : LeadCallLogRepository {

    override fun observeLeadCallLogs(leadId: Long): Flow<List<LeadCallLogEntity>> {
        return leadCallLogDao.observeLeadCallLogs(leadId)
    }

    override suspend fun addLeadCallLog(callLog: LeadCallLogEntity): Boolean {
        val result = leadCallLogDao.insertLeadCallLog(callLog) != -1L
        Log.d(
            TAG,
            "addLeadCallLog: result=$result deviceCallLogId=${callLog.deviceCallLogId} leadId=${callLog.leadId} phone=${callLog.phoneNumber}",
        )
        return result
    }

    companion object {
        private const val TAG = "EnjayCallSync"
    }
}
