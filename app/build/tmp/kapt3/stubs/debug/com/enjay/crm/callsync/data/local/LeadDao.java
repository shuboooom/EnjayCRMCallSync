package com.enjay.crm.callsync.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u00a7@\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001c2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00110\u001cH\'J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u001cH\'J\u0016\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u001aJ&\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010#\u00a8\u0006$"}, d2 = {"Lcom/enjay/crm/callsync/data/local/LeadDao;", "", "deleteLeadById", "", "leadId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findByExternalId", "Lcom/enjay/crm/callsync/data/local/LeadEntity;", "externalId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findByServerId", "serverId", "findLeadByLookupKey", "wrappedLookupKey", "getAllLeads", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLeadById", "getPendingLeads", "limit", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertLead", "lead", "(Lcom/enjay/crm/callsync/data/local/LeadEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeLeadById", "Lkotlinx/coroutines/flow/Flow;", "observeLeads", "observePendingLeadCount", "updateLead", "updateLookupKeys", "phoneLookupKeys", "updatedAt", "(JLjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface LeadDao {
    
    @androidx.room.Query(value = "SELECT * FROM leads ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.enjay.crm.callsync.data.local.LeadEntity>> observeLeads();
    
    @androidx.room.Query(value = "SELECT * FROM leads WHERE id = :leadId LIMIT 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.enjay.crm.callsync.data.local.LeadEntity> observeLeadById(long leadId);
    
    @androidx.room.Query(value = "SELECT * FROM leads WHERE id = :leadId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLeadById(long leadId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.local.LeadEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM leads")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllLeads(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enjay.crm.callsync.data.local.LeadEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM leads WHERE syncState != \'SYNCED\' ORDER BY updatedAt ASC LIMIT :limit")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPendingLeads(int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enjay.crm.callsync.data.local.LeadEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM leads WHERE syncState != \'SYNCED\'")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> observePendingLeadCount();
    
    @androidx.room.Query(value = "SELECT * FROM leads WHERE phoneLookupKeys LIKE \'%\' || :wrappedLookupKey || \'%\' LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object findLeadByLookupKey(@org.jetbrains.annotations.NotNull()
    java.lang.String wrappedLookupKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.local.LeadEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM leads WHERE serverId = :serverId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object findByServerId(@org.jetbrains.annotations.NotNull()
    java.lang.String serverId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.local.LeadEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM leads WHERE externalId = :externalId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object findByExternalId(@org.jetbrains.annotations.NotNull()
    java.lang.String externalId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.local.LeadEntity> $completion);
    
    @androidx.room.Query(value = "UPDATE leads SET phoneLookupKeys = :phoneLookupKeys, updatedAt = :updatedAt WHERE id = :leadId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateLookupKeys(long leadId, @org.jetbrains.annotations.NotNull()
    java.lang.String phoneLookupKeys, long updatedAt, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertLead(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.local.LeadEntity lead, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateLead(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.local.LeadEntity lead, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM leads WHERE id = :leadId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteLeadById(long leadId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}