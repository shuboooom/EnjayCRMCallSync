package com.enjay.crm.callsync.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/enjay/crm/callsync/data/repository/RoomLeadCallLogRepository;", "Lcom/enjay/crm/callsync/data/repository/LeadCallLogRepository;", "leadCallLogDao", "Lcom/enjay/crm/callsync/data/local/LeadCallLogDao;", "(Lcom/enjay/crm/callsync/data/local/LeadCallLogDao;)V", "addLeadCallLog", "", "callLog", "Lcom/enjay/crm/callsync/data/local/LeadCallLogEntity;", "(Lcom/enjay/crm/callsync/data/local/LeadCallLogEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeLeadCallLogs", "Lkotlinx/coroutines/flow/Flow;", "", "leadId", "", "Companion", "app_debug"})
public final class RoomLeadCallLogRepository implements com.enjay.crm.callsync.data.repository.LeadCallLogRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.local.LeadCallLogDao leadCallLogDao = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "EnjayCallSync";
    @org.jetbrains.annotations.NotNull()
    public static final com.enjay.crm.callsync.data.repository.RoomLeadCallLogRepository.Companion Companion = null;
    
    public RoomLeadCallLogRepository(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.local.LeadCallLogDao leadCallLogDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.enjay.crm.callsync.data.local.LeadCallLogEntity>> observeLeadCallLogs(long leadId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addLeadCallLog(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.local.LeadCallLogEntity callLog, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/enjay/crm/callsync/data/repository/RoomLeadCallLogRepository$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}