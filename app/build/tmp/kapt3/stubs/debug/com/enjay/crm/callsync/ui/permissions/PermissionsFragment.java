package com.enjay.crm.callsync.ui.permissions;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u001a\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0019H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\t0\t0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\""}, d2 = {"Lcom/enjay/crm/callsync/ui/permissions/PermissionsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/enjay/crm/callsync/databinding/FragmentPermissionsBinding;", "binding", "getBinding", "()Lcom/enjay/crm/callsync/databinding/FragmentPermissionsBinding;", "pendingPermission", "", "permissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "permissionStateProvider", "Lcom/enjay/crm/callsync/data/repository/PermissionStateProvider;", "getPermissionStateProvider", "()Lcom/enjay/crm/callsync/data/repository/PermissionStateProvider;", "permissionStateProvider$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/enjay/crm/callsync/ui/permissions/PermissionsViewModel;", "getViewModel", "()Lcom/enjay/crm/callsync/ui/permissions/PermissionsViewModel;", "viewModel$delegate", "onDestroyView", "", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "showSettingsDialog", "updateContinueState", "app_debug"})
public final class PermissionsFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.enjay.crm.callsync.databinding.FragmentPermissionsBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy permissionStateProvider$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String pendingPermission;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> permissionLauncher = null;
    
    public PermissionsFragment() {
        super();
    }
    
    private final com.enjay.crm.callsync.databinding.FragmentPermissionsBinding getBinding() {
        return null;
    }
    
    private final com.enjay.crm.callsync.ui.permissions.PermissionsViewModel getViewModel() {
        return null;
    }
    
    private final com.enjay.crm.callsync.data.repository.PermissionStateProvider getPermissionStateProvider() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void updateContinueState() {
    }
    
    private final void showSettingsDialog() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}