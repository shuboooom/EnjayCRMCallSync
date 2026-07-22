package com.enjay.crm.callsync.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/enjay/crm/callsync/data/repository/PermissionStateProvider;", "", "isPermanentlyDenied", "", "fragment", "Landroidx/fragment/app/Fragment;", "permission", "", "isPermissionGranted", "markPermissionRequested", "", "app_debug"})
public abstract interface PermissionStateProvider {
    
    public abstract boolean isPermissionGranted(@org.jetbrains.annotations.NotNull()
    java.lang.String permission);
    
    public abstract void markPermissionRequested(@org.jetbrains.annotations.NotNull()
    java.lang.String permission);
    
    public abstract boolean isPermanentlyDenied(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.NotNull()
    java.lang.String permission);
}