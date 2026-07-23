package com.enjay.crm.callsync.ui.postcall;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0012\u001a\u00020\u0013R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/enjay/crm/callsync/ui/postcall/PostCallDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "postCallActivityId", "", "postCallActivityRepository", "Lcom/enjay/crm/callsync/data/repository/PostCallActivityRepository;", "leadRepository", "Lcom/enjay/crm/callsync/data/repository/LeadRepository;", "(JLcom/enjay/crm/callsync/data/repository/PostCallActivityRepository;Lcom/enjay/crm/callsync/data/repository/LeadRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/enjay/crm/callsync/ui/postcall/PostCallDetailUiState;", "hasStarted", "", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "load", "", "app_debug"})
public final class PostCallDetailViewModel extends androidx.lifecycle.ViewModel {
    private final long postCallActivityId = 0L;
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.repository.PostCallActivityRepository postCallActivityRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.repository.LeadRepository leadRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.enjay.crm.callsync.ui.postcall.PostCallDetailUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.enjay.crm.callsync.ui.postcall.PostCallDetailUiState> uiState = null;
    private boolean hasStarted = false;
    
    public PostCallDetailViewModel(long postCallActivityId, @org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.repository.PostCallActivityRepository postCallActivityRepository, @org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.repository.LeadRepository leadRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.enjay.crm.callsync.ui.postcall.PostCallDetailUiState> getUiState() {
        return null;
    }
    
    public final void load() {
    }
}