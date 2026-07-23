package com.enjay.crm.callsync.ui.more;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J$\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001c*\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u001c\u0010\u001f\u001a\u00020\u0019*\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\u00020\u0014*\u00020\u00158BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006$"}, d2 = {"Lcom/enjay/crm/callsync/ui/more/MoreViewModel;", "Landroidx/lifecycle/ViewModel;", "application", "Landroid/app/Application;", "syncRepository", "Lcom/enjay/crm/callsync/data/sync/SyncRepository;", "(Landroid/app/Application;Lcom/enjay/crm/callsync/data/sync/SyncRepository;)V", "database", "Lcom/enjay/crm/callsync/data/local/AppDatabase;", "pendingSyncCountsFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/enjay/crm/callsync/ui/more/PendingSyncCounts;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/enjay/crm/callsync/ui/more/MoreUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "workManager", "Landroidx/work/WorkManager;", "priority", "", "Landroidx/work/WorkInfo$State;", "getPriority", "(Landroidx/work/WorkInfo$State;)I", "selectWorkDebugState", "Lcom/enjay/crm/callsync/ui/more/SyncWorkDebugState;", "immediateWorkInfos", "", "Landroidx/work/WorkInfo;", "periodicWorkInfos", "bestCandidate", "toDebugState", "workerType", "", "isSyncRunning", "", "app_debug"})
public final class MoreViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.work.WorkManager workManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.local.AppDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.enjay.crm.callsync.ui.more.PendingSyncCounts> pendingSyncCountsFlow = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.enjay.crm.callsync.ui.more.MoreUiState> uiState = null;
    
    public MoreViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.sync.SyncRepository syncRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.enjay.crm.callsync.ui.more.MoreUiState> getUiState() {
        return null;
    }
    
    private final com.enjay.crm.callsync.ui.more.SyncWorkDebugState selectWorkDebugState(java.util.List<androidx.work.WorkInfo> immediateWorkInfos, java.util.List<androidx.work.WorkInfo> periodicWorkInfos) {
        return null;
    }
    
    private final androidx.work.WorkInfo bestCandidate(java.util.List<androidx.work.WorkInfo> $this$bestCandidate) {
        return null;
    }
    
    private final com.enjay.crm.callsync.ui.more.SyncWorkDebugState toDebugState(androidx.work.WorkInfo $this$toDebugState, java.lang.String workerType, boolean isSyncRunning) {
        return null;
    }
    
    private final int getPriority(androidx.work.WorkInfo.State $this$priority) {
        return 0;
    }
}