package com.enjay.crm.callsync.ui.permissions;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u0014R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/enjay/crm/callsync/ui/permissions/PermissionsViewModel;", "Landroidx/lifecycle/ViewModel;", "permissionStateProvider", "Lcom/enjay/crm/callsync/data/repository/PermissionStateProvider;", "(Lcom/enjay/crm/callsync/data/repository/PermissionStateProvider;)V", "_permissions", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/enjay/crm/callsync/data/model/PermissionItem;", "permissions", "Lkotlinx/coroutines/flow/StateFlow;", "getPermissions", "()Lkotlinx/coroutines/flow/StateFlow;", "requiredPermissions", "", "getRequiredPermissions", "()Ljava/util/List;", "areAllGranted", "", "markRequested", "", "permission", "refreshPermissions", "app_debug"})
public final class PermissionsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.repository.PermissionStateProvider permissionStateProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.enjay.crm.callsync.data.model.PermissionItem>> _permissions = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.enjay.crm.callsync.data.model.PermissionItem>> permissions = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> requiredPermissions = null;
    
    public PermissionsViewModel(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.repository.PermissionStateProvider permissionStateProvider) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.enjay.crm.callsync.data.model.PermissionItem>> getPermissions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getRequiredPermissions() {
        return null;
    }
    
    public final void refreshPermissions() {
    }
    
    public final void markRequested(@org.jetbrains.annotations.NotNull()
    java.lang.String permission) {
    }
    
    public final boolean areAllGranted() {
        return false;
    }
}