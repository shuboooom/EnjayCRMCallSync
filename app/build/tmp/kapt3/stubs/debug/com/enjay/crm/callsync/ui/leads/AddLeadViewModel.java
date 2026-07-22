package com.enjay.crm.callsync.ui.leads;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/enjay/crm/callsync/ui/leads/AddLeadViewModel;", "Landroidx/lifecycle/ViewModel;", "leadRepository", "Lcom/enjay/crm/callsync/data/repository/LeadRepository;", "(Lcom/enjay/crm/callsync/data/repository/LeadRepository;)V", "events", "Lkotlinx/coroutines/flow/Flow;", "Lcom/enjay/crm/callsync/ui/leads/AddLeadEvent;", "getEvents", "()Lkotlinx/coroutines/flow/Flow;", "eventsChannel", "Lkotlinx/coroutines/channels/Channel;", "saveLead", "Lcom/enjay/crm/callsync/ui/leads/AddLeadValidationResult;", "name", "", "phone", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AddLeadViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.repository.LeadRepository leadRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<com.enjay.crm.callsync.ui.leads.AddLeadEvent> eventsChannel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.enjay.crm.callsync.ui.leads.AddLeadEvent> events = null;
    
    public AddLeadViewModel(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.repository.LeadRepository leadRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.enjay.crm.callsync.ui.leads.AddLeadEvent> getEvents() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveLead(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.ui.leads.AddLeadValidationResult> $completion) {
        return null;
    }
}