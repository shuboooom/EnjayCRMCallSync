package com.enjay.crm.callsync.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0012H\u0014J\b\u0010\u001a\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001d"}, d2 = {"Lcom/enjay/crm/callsync/ui/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "appBarConfiguration", "Landroidx/navigation/ui/AppBarConfiguration;", "binding", "Lcom/enjay/crm/callsync/databinding/ActivityMainBinding;", "bottomNavVisible", "", "navController", "Landroidx/navigation/NavController;", "permissionStateProvider", "Lcom/enjay/crm/callsync/data/repository/PermissionStateProvider;", "getPermissionStateProvider", "()Lcom/enjay/crm/callsync/data/repository/PermissionStateProvider;", "permissionStateProvider$delegate", "Lkotlin/Lazy;", "applyWindowInsets", "", "configureStartDestination", "graph", "Landroidx/navigation/NavGraph;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onSupportNavigateUp", "setBottomNavVisible", "show", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.enjay.crm.callsync.databinding.ActivityMainBinding binding;
    private androidx.navigation.NavController navController;
    private androidx.navigation.ui.AppBarConfiguration appBarConfiguration;
    private boolean bottomNavVisible = true;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy permissionStateProvider$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    private final com.enjay.crm.callsync.data.repository.PermissionStateProvider getPermissionStateProvider() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void configureStartDestination(androidx.navigation.NavGraph graph) {
    }
    
    private final void applyWindowInsets() {
    }
    
    private final void setBottomNavVisible(boolean show) {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
}