package com.enjay.crm.callsync.data.repository

import com.enjay.crm.callsync.data.model.DeviceContactMatch

interface ContactsRepository {
    suspend fun findContactByPhoneNumber(phoneNumber: String): DeviceContactMatch?
}
