package com.enjay.crm.callsync.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/enjay/crm/callsync/data/repository/AndroidPermissionStateProvider;", "Lcom/enjay/crm/callsync/data/repository/PermissionStateProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appContext", "kotlin.jvm.PlatformType", "preferences", "Landroid/content/SharedPreferences;", "isPermanentlyDenied", "", "fragment", "Landroidx/fragment/app/Fragment;", "permission", "", "isPermissionGranted", "markPermissionRequested", "", "app_debug"})
public final class AndroidPermissionStateProvider implements com.enjay.crm.callsync.data.repository.PermissionStateProvider {
    private final android.content.Context appContext = null;
    private final android.content.SharedPreferences preferences = null;
    
    public AndroidPermissionStateProvider(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override()
    public boolean isPermissionGranted(@org.jetbrains.annotations.NotNull()
    java.lang.String permission) {
        return false;
    }
    
    @java.lang.Override()
    public void markPermissionRequested(@org.jetbrains.annotations.NotNull()
    java.lang.String permission) {
    }
    
    @java.lang.Override()
    public boolean isPermanentlyDenied(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.NotNull()
    java.lang.String permission) {
        return false;
    }
}