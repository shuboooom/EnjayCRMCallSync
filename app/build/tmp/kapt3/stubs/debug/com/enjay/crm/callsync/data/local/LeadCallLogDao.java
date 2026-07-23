package com.enjay.crm.callsync.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000e0\u00162\u0006\u0010\u0017\u001a\u00020\u000bH\'J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016H\'J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/enjay/crm/callsync/data/local/LeadCallLogDao;", "", "findByExternalId", "Lcom/enjay/crm/callsync/data/local/LeadCallLogEntity;", "externalId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findByServerId", "serverId", "getById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPendingLeadCallLogs", "", "limit", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertLeadCallLog", "callLog", "(Lcom/enjay/crm/callsync/data/local/LeadCallLogEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeLeadCallLogs", "Lkotlinx/coroutines/flow/Flow;", "leadId", "observePendingLeadCallLogCount", "reassignLead", "", "fromLeadId", "toLeadId", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLeadCallLog", "app_debug"})
@androidx.room.Dao()
public abstract interface LeadCallLogDao {
    
    @androidx.room.Query(value = "SELECT * FROM lead_call_logs WHERE leadId = :leadId ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.enjay.crm.callsync.data.local.LeadCallLogEntity>> observeLeadCallLogs(long leadId);
    
    @androidx.room.Query(value = "SELECT * FROM lead_call_logs WHERE syncState != \'SYNCED\' ORDER BY timestamp ASC LIMIT :limit")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPendingLeadCallLogs(int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enjay.crm.callsync.data.local.LeadCallLogEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM lead_call_logs WHERE syncState != \'SYNCED\'")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> observePendingLeadCallLogCount();
    
    @androidx.room.Query(value = "SELECT * FROM lead_call_logs WHERE id = :id LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.local.LeadCallLogEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM lead_call_logs WHERE serverId = :serverId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object findByServerId(@org.jetbrains.annotations.NotNull()
    java.lang.String serverId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.local.LeadCallLogEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM lead_call_logs WHERE externalId = :externalId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object findByExternalId(@org.jetbrains.annotations.NotNull()
    java.lang.String externalId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.local.LeadCallLogEntity> $completion);
    
    @androidx.room.Insert(onConflict = 5)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertLeadCallLog(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.local.LeadCallLogEntity callLog, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateLeadCallLog(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.local.LeadCallLogEntity callLog, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE lead_call_logs SET leadId = :toLeadId WHERE leadId = :fromLeadId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object reassignLead(long fromLeadId, long toLeadId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}