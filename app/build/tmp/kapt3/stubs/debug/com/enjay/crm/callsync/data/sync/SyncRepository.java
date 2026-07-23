package com.enjay.crm.callsync.data.sync;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H&J\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u00a6@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/enjay/crm/callsync/data/sync/SyncRepository;", "", "observeSyncCursorState", "Lkotlinx/coroutines/flow/Flow;", "Lcom/enjay/crm/callsync/data/sync/SyncCursorState;", "runSync", "Lkotlin/Pair;", "Lcom/enjay/crm/callsync/data/sync/PushResultDto;", "Lcom/enjay/crm/callsync/data/sync/PullResultDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface SyncRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.enjay.crm.callsync.data.sync.SyncCursorState> observeSyncCursorState();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object runSync(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Pair<com.enjay.crm.callsync.data.sync.PushResultDto, com.enjay.crm.callsync.data.sync.PullResultDto>> $completion);
}