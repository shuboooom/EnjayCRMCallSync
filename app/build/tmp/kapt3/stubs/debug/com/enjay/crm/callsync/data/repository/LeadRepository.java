package com.enjay.crm.callsync.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00132\u0006\u0010\u0010\u001a\u00020\u0003H&J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00150\u0013H&\u00a8\u0006\u0016"}, d2 = {"Lcom/enjay/crm/callsync/data/repository/LeadRepository;", "", "addLead", "", "name", "", "phone", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "backfillPhoneLookupKeys", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findLeadByPhoneNumber", "Lcom/enjay/crm/callsync/data/local/LeadEntity;", "phoneNumber", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLeadById", "leadId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeLeadById", "Lkotlinx/coroutines/flow/Flow;", "observeLeads", "", "app_debug"})
public abstract interface LeadRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.enjay.crm.callsync.data.local.LeadEntity>> observeLeads();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.enjay.crm.callsync.data.local.LeadEntity> observeLeadById(long leadId);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLeadById(long leadId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.local.LeadEntity> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addLead(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object findLeadByPhoneNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumber, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.local.LeadEntity> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object backfillPhoneLookupKeys(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}