package com.enjay.crm.callsync.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/enjay/crm/callsync/data/repository/LeadCallLogRepository;", "", "addLeadCallLog", "", "callLog", "Lcom/enjay/crm/callsync/data/local/LeadCallLogEntity;", "(Lcom/enjay/crm/callsync/data/local/LeadCallLogEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeLeadCallLogs", "Lkotlinx/coroutines/flow/Flow;", "", "leadId", "", "app_debug"})
public abstract interface LeadCallLogRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.enjay.crm.callsync.data.local.LeadCallLogEntity>> observeLeadCallLogs(long leadId);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addLeadCallLog(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.local.LeadCallLogEntity callLog, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
}