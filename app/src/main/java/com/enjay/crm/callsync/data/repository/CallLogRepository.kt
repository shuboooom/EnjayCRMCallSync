package com.enjay.crm.callsync.data.repository

import com.enjay.crm.callsync.data.model.CallLogItem

interface CallLogRepository {
    suspend fun getRecentCalls(limit: Int = 100): List<CallLogItem>
    suspend fun getMostRecentCall(): CallLogItem?
}
