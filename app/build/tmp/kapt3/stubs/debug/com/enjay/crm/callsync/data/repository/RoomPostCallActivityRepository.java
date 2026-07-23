package com.enjay.crm.callsync.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0096@\u00a2\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000f2\u0006\u0010\f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/enjay/crm/callsync/data/repository/RoomPostCallActivityRepository;", "Lcom/enjay/crm/callsync/data/repository/PostCallActivityRepository;", "postCallActivityDao", "Lcom/enjay/crm/callsync/data/local/PostCallActivityDao;", "(Lcom/enjay/crm/callsync/data/local/PostCallActivityDao;)V", "addPostCallActivity", "", "activity", "Lcom/enjay/crm/callsync/data/local/PostCallActivityEntity;", "(Lcom/enjay/crm/callsync/data/local/PostCallActivityEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "assignExternalIdIfMissing", "", "activityId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observePostCallActivitiesByLeadId", "Lkotlinx/coroutines/flow/Flow;", "", "leadId", "observePostCallActivityById", "Companion", "app_debug"})
public final class RoomPostCallActivityRepository implements com.enjay.crm.callsync.data.repository.PostCallActivityRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.local.PostCallActivityDao postCallActivityDao = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "EnjayCallSync";
    @org.jetbrains.annotations.NotNull()
    public static final com.enjay.crm.callsync.data.repository.RoomPostCallActivityRepository.Companion Companion = null;
    
    public RoomPostCallActivityRepository(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.local.PostCallActivityDao postCallActivityDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addPostCallActivity(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.local.PostCallActivityEntity activity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object assignExternalIdIfMissing(long activityId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.enjay.crm.callsync.data.local.PostCallActivityEntity>> observePostCallActivitiesByLeadId(long leadId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.enjay.crm.callsync.data.local.PostCallActivityEntity> observePostCallActivityById(long activityId) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/enjay/crm/callsync/data/repository/RoomPostCallActivityRepository$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}