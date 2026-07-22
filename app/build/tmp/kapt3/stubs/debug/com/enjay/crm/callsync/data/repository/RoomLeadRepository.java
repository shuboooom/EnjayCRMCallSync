package com.enjay.crm.callsync.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0006H\u0096@\u00a2\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00162\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00180\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/enjay/crm/callsync/data/repository/RoomLeadRepository;", "Lcom/enjay/crm/callsync/data/repository/LeadRepository;", "leadDao", "Lcom/enjay/crm/callsync/data/local/LeadDao;", "(Lcom/enjay/crm/callsync/data/local/LeadDao;)V", "addLead", "", "name", "", "phone", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "backfillPhoneLookupKeys", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findLeadByPhoneNumber", "Lcom/enjay/crm/callsync/data/local/LeadEntity;", "phoneNumber", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLeadById", "leadId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeLeadById", "Lkotlinx/coroutines/flow/Flow;", "observeLeads", "", "Companion", "app_debug"})
public final class RoomLeadRepository implements com.enjay.crm.callsync.data.repository.LeadRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.local.LeadDao leadDao = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "EnjayCallSync";
    @org.jetbrains.annotations.NotNull()
    public static final com.enjay.crm.callsync.data.repository.RoomLeadRepository.Companion Companion = null;
    
    public RoomLeadRepository(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.local.LeadDao leadDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.enjay.crm.callsync.data.local.LeadEntity>> observeLeads() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.enjay.crm.callsync.data.local.LeadEntity> observeLeadById(long leadId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getLeadById(long leadId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.local.LeadEntity> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addLead(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object findLeadByPhoneNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumber, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.local.LeadEntity> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object backfillPhoneLookupKeys(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/enjay/crm/callsync/data/repository/RoomLeadRepository$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}