package com.enjay.crm.callsync.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020\'8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010\f\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010\f\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010\f\u001a\u0004\b2\u00103R\u001b\u00105\u001a\u0002068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010\f\u001a\u0004\b7\u00108R\u001b\u0010:\u001a\u00020;8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010\f\u001a\u0004\b<\u0010=\u00a8\u0006?"}, d2 = {"Lcom/enjay/crm/callsync/data/AppContainer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appContext", "kotlin.jvm.PlatformType", "callLogRepository", "Lcom/enjay/crm/callsync/data/repository/CallLogRepository;", "getCallLogRepository", "()Lcom/enjay/crm/callsync/data/repository/CallLogRepository;", "callLogRepository$delegate", "Lkotlin/Lazy;", "contactsRepository", "Lcom/enjay/crm/callsync/data/repository/ContactsRepository;", "getContactsRepository", "()Lcom/enjay/crm/callsync/data/repository/ContactsRepository;", "contactsRepository$delegate", "database", "Lcom/enjay/crm/callsync/data/local/AppDatabase;", "getDatabase", "()Lcom/enjay/crm/callsync/data/local/AppDatabase;", "database$delegate", "leadCallLogRepository", "Lcom/enjay/crm/callsync/data/repository/LeadCallLogRepository;", "getLeadCallLogRepository", "()Lcom/enjay/crm/callsync/data/repository/LeadCallLogRepository;", "leadCallLogRepository$delegate", "leadRepository", "Lcom/enjay/crm/callsync/data/repository/LeadRepository;", "getLeadRepository", "()Lcom/enjay/crm/callsync/data/repository/LeadRepository;", "leadRepository$delegate", "permissionStateProvider", "Lcom/enjay/crm/callsync/data/repository/PermissionStateProvider;", "getPermissionStateProvider", "()Lcom/enjay/crm/callsync/data/repository/PermissionStateProvider;", "permissionStateProvider$delegate", "postCallActivityRepository", "Lcom/enjay/crm/callsync/data/repository/PostCallActivityRepository;", "getPostCallActivityRepository", "()Lcom/enjay/crm/callsync/data/repository/PostCallActivityRepository;", "postCallActivityRepository$delegate", "syncApi", "Lcom/enjay/crm/callsync/data/sync/SyncApi;", "getSyncApi", "()Lcom/enjay/crm/callsync/data/sync/SyncApi;", "syncApi$delegate", "syncCoordinator", "Lcom/enjay/crm/callsync/data/sync/SyncCoordinator;", "getSyncCoordinator", "()Lcom/enjay/crm/callsync/data/sync/SyncCoordinator;", "syncCoordinator$delegate", "syncMetadataRepository", "Lcom/enjay/crm/callsync/data/repository/SyncMetadataRepository;", "getSyncMetadataRepository", "()Lcom/enjay/crm/callsync/data/repository/SyncMetadataRepository;", "syncMetadataRepository$delegate", "syncRepository", "Lcom/enjay/crm/callsync/data/sync/SyncRepository;", "getSyncRepository", "()Lcom/enjay/crm/callsync/data/sync/SyncRepository;", "syncRepository$delegate", "app_debug"})
public final class AppContainer {
    private final android.content.Context appContext = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy database$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy leadRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy leadCallLogRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy postCallActivityRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy syncMetadataRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy callLogRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy contactsRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy permissionStateProvider$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy syncApi$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy syncRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy syncCoordinator$delegate = null;
    
    public AppContainer(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enjay.crm.callsync.data.local.AppDatabase getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enjay.crm.callsync.data.repository.LeadRepository getLeadRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enjay.crm.callsync.data.repository.LeadCallLogRepository getLeadCallLogRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enjay.crm.callsync.data.repository.PostCallActivityRepository getPostCallActivityRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enjay.crm.callsync.data.repository.SyncMetadataRepository getSyncMetadataRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enjay.crm.callsync.data.repository.CallLogRepository getCallLogRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enjay.crm.callsync.data.repository.ContactsRepository getContactsRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enjay.crm.callsync.data.repository.PermissionStateProvider getPermissionStateProvider() {
        return null;
    }
    
    private final com.enjay.crm.callsync.data.sync.SyncApi getSyncApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enjay.crm.callsync.data.sync.SyncRepository getSyncRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enjay.crm.callsync.data.sync.SyncCoordinator getSyncCoordinator() {
        return null;
    }
}