package com.enjay.crm.callsync.data.repository

class DuplicateLeadException(
    val existingLeadId: Long,
) : IllegalStateException("Lead with matching phone number already exists.")
