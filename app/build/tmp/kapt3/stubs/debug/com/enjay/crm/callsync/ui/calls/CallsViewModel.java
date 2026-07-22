package com.enjay.crm.callsync.ui.calls;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/enjay/crm/callsync/ui/calls/CallsViewModel;", "Landroidx/lifecycle/ViewModel;", "callLogRepository", "Lcom/enjay/crm/callsync/data/repository/CallLogRepository;", "leadRepository", "Lcom/enjay/crm/callsync/data/repository/LeadRepository;", "permissionStateProvider", "Lcom/enjay/crm/callsync/data/repository/PermissionStateProvider;", "(Lcom/enjay/crm/callsync/data/repository/CallLogRepository;Lcom/enjay/crm/callsync/data/repository/LeadRepository;Lcom/enjay/crm/callsync/data/repository/PermissionStateProvider;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/enjay/crm/callsync/ui/calls/CallsUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadCalls", "", "selectTab", "tab", "Lcom/enjay/crm/callsync/ui/calls/CallsTab;", "app_debug"})
public final class CallsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.repository.CallLogRepository callLogRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.repository.LeadRepository leadRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.repository.PermissionStateProvider permissionStateProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.enjay.crm.callsync.ui.calls.CallsUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.enjay.crm.callsync.ui.calls.CallsUiState> uiState = null;
    
    public CallsViewModel(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.repository.CallLogRepository callLogRepository, @org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.repository.LeadRepository leadRepository, @org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.repository.PermissionStateProvider permissionStateProvider) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.enjay.crm.callsync.ui.calls.CallsUiState> getUiState() {
        return null;
    }
    
    public final void loadCalls() {
    }
    
    public final void selectTab(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.ui.calls.CallsTab tab) {
    }
}