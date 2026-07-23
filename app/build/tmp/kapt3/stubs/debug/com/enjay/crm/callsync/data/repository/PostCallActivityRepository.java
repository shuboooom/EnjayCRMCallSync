package com.enjay.crm.callsync.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u000e\u001a\u00020\u0003H&J\u0018\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f2\u0006\u0010\t\u001a\u00020\u0003H&\u00a8\u0006\u0010"}, d2 = {"Lcom/enjay/crm/callsync/data/repository/PostCallActivityRepository;", "", "addPostCallActivity", "", "activity", "Lcom/enjay/crm/callsync/data/local/PostCallActivityEntity;", "(Lcom/enjay/crm/callsync/data/local/PostCallActivityEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "assignExternalIdIfMissing", "", "activityId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observePostCallActivitiesByLeadId", "Lkotlinx/coroutines/flow/Flow;", "", "leadId", "observePostCallActivityById", "app_debug"})
public abstract interface PostCallActivityRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addPostCallActivity(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.local.PostCallActivityEntity activity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object assignExternalIdIfMissing(long activityId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.enjay.crm.callsync.data.local.PostCallActivityEntity>> observePostCallActivitiesByLeadId(long leadId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.enjay.crm.callsync.data.local.PostCallActivityEntity> observePostCallActivityById(long activityId);
}