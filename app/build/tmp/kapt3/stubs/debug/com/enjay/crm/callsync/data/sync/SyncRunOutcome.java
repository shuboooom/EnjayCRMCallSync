package com.enjay.crm.callsync.data.sync;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/enjay/crm/callsync/data/sync/SyncRunOutcome;", "", "AlreadyRunning", "Completed", "Lcom/enjay/crm/callsync/data/sync/SyncRunOutcome$AlreadyRunning;", "Lcom/enjay/crm/callsync/data/sync/SyncRunOutcome$Completed;", "app_debug"})
public abstract interface SyncRunOutcome {
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/enjay/crm/callsync/data/sync/SyncRunOutcome$AlreadyRunning;", "Lcom/enjay/crm/callsync/data/sync/SyncRunOutcome;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class AlreadyRunning implements com.enjay.crm.callsync.data.sync.SyncRunOutcome {
        @org.jetbrains.annotations.NotNull()
        public static final com.enjay.crm.callsync.data.sync.SyncRunOutcome.AlreadyRunning INSTANCE = null;
        
        private AlreadyRunning() {
            super();
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u00c6\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/enjay/crm/callsync/data/sync/SyncRunOutcome$Completed;", "Lcom/enjay/crm/callsync/data/sync/SyncRunOutcome;", "result", "Lkotlin/Pair;", "Lcom/enjay/crm/callsync/data/sync/PushResultDto;", "Lcom/enjay/crm/callsync/data/sync/PullResultDto;", "(Lkotlin/Pair;)V", "getResult", "()Lkotlin/Pair;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class Completed implements com.enjay.crm.callsync.data.sync.SyncRunOutcome {
        @org.jetbrains.annotations.NotNull()
        private final kotlin.Pair<com.enjay.crm.callsync.data.sync.PushResultDto, com.enjay.crm.callsync.data.sync.PullResultDto> result = null;
        
        public Completed(@org.jetbrains.annotations.NotNull()
        kotlin.Pair<com.enjay.crm.callsync.data.sync.PushResultDto, com.enjay.crm.callsync.data.sync.PullResultDto> result) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.Pair<com.enjay.crm.callsync.data.sync.PushResultDto, com.enjay.crm.callsync.data.sync.PullResultDto> getResult() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.Pair<com.enjay.crm.callsync.data.sync.PushResultDto, com.enjay.crm.callsync.data.sync.PullResultDto> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.enjay.crm.callsync.data.sync.SyncRunOutcome.Completed copy(@org.jetbrains.annotations.NotNull()
        kotlin.Pair<com.enjay.crm.callsync.data.sync.PushResultDto, com.enjay.crm.callsync.data.sync.PullResultDto> result) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}