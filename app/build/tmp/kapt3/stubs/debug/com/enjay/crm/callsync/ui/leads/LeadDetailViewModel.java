package com.enjay.crm.callsync.ui.leads;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\u0016\u001a\u00020\u0017R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/enjay/crm/callsync/ui/leads/LeadDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "leadId", "", "leadRepository", "Lcom/enjay/crm/callsync/data/repository/LeadRepository;", "leadCallLogRepository", "Lcom/enjay/crm/callsync/data/repository/LeadCallLogRepository;", "postCallActivityRepository", "Lcom/enjay/crm/callsync/data/repository/PostCallActivityRepository;", "contactsRepository", "Lcom/enjay/crm/callsync/data/repository/ContactsRepository;", "(JLcom/enjay/crm/callsync/data/repository/LeadRepository;Lcom/enjay/crm/callsync/data/repository/LeadCallLogRepository;Lcom/enjay/crm/callsync/data/repository/PostCallActivityRepository;Lcom/enjay/crm/callsync/data/repository/ContactsRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/enjay/crm/callsync/ui/leads/LeadDetailUiState;", "hasStarted", "", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadLead", "", "app_debug"})
public final class LeadDetailViewModel extends androidx.lifecycle.ViewModel {
    private final long leadId = 0L;
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.repository.LeadRepository leadRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.repository.LeadCallLogRepository leadCallLogRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.repository.PostCallActivityRepository postCallActivityRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.repository.ContactsRepository contactsRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.enjay.crm.callsync.ui.leads.LeadDetailUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.enjay.crm.callsync.ui.leads.LeadDetailUiState> uiState = null;
    private boolean hasStarted = false;
    
    public LeadDetailViewModel(long leadId, @org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.repository.LeadRepository leadRepository, @org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.repository.LeadCallLogRepository leadCallLogRepository, @org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.repository.PostCallActivityRepository postCallActivityRepository, @org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.repository.ContactsRepository contactsRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.enjay.crm.callsync.ui.leads.LeadDetailUiState> getUiState() {
        return null;
    }
    
    public final void loadLead() {
    }
}