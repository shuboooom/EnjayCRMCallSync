package com.enjay.crm.callsync.data.repository

import com.enjay.crm.callsync.data.local.LeadEntity
import kotlinx.coroutines.flow.Flow

interface LeadRepository {
    fun observeLeads(): Flow<List<LeadEntity>>
    fun observeLeadById(leadId: Long): Flow<LeadEntity?>
    suspend fun getLeadById(leadId: Long): LeadEntity?
    suspend fun addLead(name: String, phone: String): Long
    suspend fun findLeadByPhoneNumber(phoneNumber: String): LeadEntity?
    suspend fun backfillPhoneLookupKeys()
}
