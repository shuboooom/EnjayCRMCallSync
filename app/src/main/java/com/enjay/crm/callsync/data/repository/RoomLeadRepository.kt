package com.enjay.crm.callsync.data.repository

import android.util.Log
import com.enjay.crm.callsync.data.local.LeadDao
import com.enjay.crm.callsync.data.local.LeadEntity
import com.enjay.crm.callsync.util.PhoneNumberNormalizer
import kotlinx.coroutines.flow.Flow

class RoomLeadRepository(
    private val leadDao: LeadDao,
) : LeadRepository {

    override fun observeLeads(): Flow<List<LeadEntity>> = leadDao.observeLeads()

    override fun observeLeadById(leadId: Long): Flow<LeadEntity?> = leadDao.observeLeadById(leadId)

    override suspend fun getLeadById(leadId: Long): LeadEntity? = leadDao.getLeadById(leadId)

    override suspend fun addLead(name: String, phone: String): Long {
        val now = System.currentTimeMillis()
        return leadDao.insertLead(
            LeadEntity(
                name = name,
                phone = phone,
                phoneLookupKeys = com.enjay.crm.callsync.util.PhoneNumberNormalizer.lookupKeyBlob(phone),
                createdAt = now,
                updatedAt = now,
            ),
        )
    }

    override suspend fun findLeadByPhoneNumber(phoneNumber: String): LeadEntity? {
        val lookupKeys = PhoneNumberNormalizer.lookupKeys(phoneNumber)
        Log.d(TAG, "findLeadByPhoneNumber: phone=$phoneNumber lookupKeys=$lookupKeys")
        if (lookupKeys.isEmpty()) return null

        fun String.asWrappedToken(): String = "|$this|"

        lookupKeys.forEach { key ->
            leadDao.findLeadByLookupKey(key.asWrappedToken())?.let {
                Log.d(TAG, "findLeadByPhoneNumber: matched without backfill leadId=${it.id} key=$key")
                return it
            }
        }

        backfillPhoneLookupKeys()

        lookupKeys.forEach { key ->
            leadDao.findLeadByLookupKey(key.asWrappedToken())?.let {
                Log.d(TAG, "findLeadByPhoneNumber: matched after backfill leadId=${it.id} key=$key")
                return it
            }
        }
        Log.d(TAG, "findLeadByPhoneNumber: no match for phone=$phoneNumber")
        return null
    }

    override suspend fun backfillPhoneLookupKeys() {
        val now = System.currentTimeMillis()
        leadDao.getAllLeads().forEach { lead ->
            val updatedKeys = PhoneNumberNormalizer.lookupKeyBlob(lead.phone)
            if (lead.phoneLookupKeys != updatedKeys) {
                leadDao.updateLookupKeys(lead.id, updatedKeys, now)
                Log.d(TAG, "backfillPhoneLookupKeys: updated leadId=${lead.id} keys=$updatedKeys")
            }
        }
    }

    companion object {
        private const val TAG = "EnjayCallSync"
    }
}
