package com.enjay.crm.callsync.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/enjay/crm/callsync/data/local/SyncState;", "", "(Ljava/lang/String;I)V", "PENDING_CREATE", "PENDING_UPDATE", "SYNCED", "FAILED_RETRYABLE", "FAILED_PERMANENT", "app_debug"})
public enum SyncState {
    /*public static final*/ PENDING_CREATE /* = new PENDING_CREATE() */,
    /*public static final*/ PENDING_UPDATE /* = new PENDING_UPDATE() */,
    /*public static final*/ SYNCED /* = new SYNCED() */,
    /*public static final*/ FAILED_RETRYABLE /* = new FAILED_RETRYABLE() */,
    /*public static final*/ FAILED_PERMANENT /* = new FAILED_PERMANENT() */;
    
    SyncState() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.enjay.crm.callsync.data.local.SyncState> getEntries() {
        return null;
    }
}