package com.enjay.crm.callsync.data.local

enum class SyncState {
    PENDING_CREATE,
    PENDING_UPDATE,
    SYNCED,
    FAILED_RETRYABLE,
    FAILED_PERMANENT,
}
