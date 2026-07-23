package com.enjay.crm.callsync.ui.leads

import com.enjay.crm.callsync.data.local.LeadCallLogEntity
import com.enjay.crm.callsync.data.local.PostCallActivityEntity

data class LeadCallLogItemUiModel(
    val callLog: LeadCallLogEntity,
    val postCallActivity: PostCallActivityEntity?,
)
