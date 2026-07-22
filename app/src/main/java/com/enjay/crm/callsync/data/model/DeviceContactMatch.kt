package com.enjay.crm.callsync.data.model

import android.net.Uri

data class DeviceContactMatch(
    val contactId: Long,
    val displayName: String,
    val phoneNumber: String,
    val lookupUri: Uri,
)
