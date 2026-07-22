package com.enjay.crm.callsync.data.model

data class CallLogItem(
    val id: Long,
    val name: String?,
    val phoneNumber: String?,
    val callType: CallType,
    val timestamp: Long,
    val durationSeconds: Long,
)

enum class CallType {
    INCOMING,
    OUTGOING,
    MISSED,
    REJECTED,
    OTHER,
}
