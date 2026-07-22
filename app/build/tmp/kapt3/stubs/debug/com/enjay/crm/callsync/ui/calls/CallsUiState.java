package com.enjay.crm.callsync.ui.calls;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003JG\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001f"}, d2 = {"Lcom/enjay/crm/callsync/ui/calls/CallsUiState;", "", "isLoading", "", "hasPermission", "selectedTab", "Lcom/enjay/crm/callsync/ui/calls/CallsTab;", "personalCalls", "", "Lcom/enjay/crm/callsync/data/model/CallLogItem;", "businessCalls", "(ZZLcom/enjay/crm/callsync/ui/calls/CallsTab;Ljava/util/List;Ljava/util/List;)V", "getBusinessCalls", "()Ljava/util/List;", "getHasPermission", "()Z", "getPersonalCalls", "getSelectedTab", "()Lcom/enjay/crm/callsync/ui/calls/CallsTab;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"})
public final class CallsUiState {
    private final boolean isLoading = false;
    private final boolean hasPermission = false;
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.ui.calls.CallsTab selectedTab = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.enjay.crm.callsync.data.model.CallLogItem> personalCalls = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.enjay.crm.callsync.data.model.CallLogItem> businessCalls = null;
    
    public CallsUiState(boolean isLoading, boolean hasPermission, @org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.ui.calls.CallsTab selectedTab, @org.jetbrains.annotations.NotNull()
    java.util.List<com.enjay.crm.callsync.data.model.CallLogItem> personalCalls, @org.jetbrains.annotations.NotNull()
    java.util.List<com.enjay.crm.callsync.data.model.CallLogItem> businessCalls) {
        super();
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public final boolean getHasPermission() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enjay.crm.callsync.ui.calls.CallsTab getSelectedTab() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.enjay.crm.callsync.data.model.CallLogItem> getPersonalCalls() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.enjay.crm.callsync.data.model.CallLogItem> getBusinessCalls() {
        return null;
    }
    
    public CallsUiState() {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean component2() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enjay.crm.callsync.ui.calls.CallsTab component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.enjay.crm.callsync.data.model.CallLogItem> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.enjay.crm.callsync.data.model.CallLogItem> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enjay.crm.callsync.ui.calls.CallsUiState copy(boolean isLoading, boolean hasPermission, @org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.ui.calls.CallsTab selectedTab, @org.jetbrains.annotations.NotNull()
    java.util.List<com.enjay.crm.callsync.data.model.CallLogItem> personalCalls, @org.jetbrains.annotations.NotNull()
    java.util.List<com.enjay.crm.callsync.data.model.CallLogItem> businessCalls) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}