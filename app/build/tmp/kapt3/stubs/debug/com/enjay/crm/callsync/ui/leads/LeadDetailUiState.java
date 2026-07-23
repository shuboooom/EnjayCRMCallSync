package com.enjay.crm.callsync.ui.leads;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/enjay/crm/callsync/ui/leads/LeadDetailUiState;", "", "isLoading", "", "lead", "Lcom/enjay/crm/callsync/data/local/LeadEntity;", "deviceContact", "Lcom/enjay/crm/callsync/data/model/DeviceContactMatch;", "callLogs", "", "Lcom/enjay/crm/callsync/ui/leads/LeadCallLogItemUiModel;", "(ZLcom/enjay/crm/callsync/data/local/LeadEntity;Lcom/enjay/crm/callsync/data/model/DeviceContactMatch;Ljava/util/List;)V", "getCallLogs", "()Ljava/util/List;", "getDeviceContact", "()Lcom/enjay/crm/callsync/data/model/DeviceContactMatch;", "()Z", "getLead", "()Lcom/enjay/crm/callsync/data/local/LeadEntity;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"})
public final class LeadDetailUiState {
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable()
    private final com.enjay.crm.callsync.data.local.LeadEntity lead = null;
    @org.jetbrains.annotations.Nullable()
    private final com.enjay.crm.callsync.data.model.DeviceContactMatch deviceContact = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.enjay.crm.callsync.ui.leads.LeadCallLogItemUiModel> callLogs = null;
    
    public LeadDetailUiState(boolean isLoading, @org.jetbrains.annotations.Nullable()
    com.enjay.crm.callsync.data.local.LeadEntity lead, @org.jetbrains.annotations.Nullable()
    com.enjay.crm.callsync.data.model.DeviceContactMatch deviceContact, @org.jetbrains.annotations.NotNull()
    java.util.List<com.enjay.crm.callsync.ui.leads.LeadCallLogItemUiModel> callLogs) {
        super();
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.enjay.crm.callsync.data.local.LeadEntity getLead() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.enjay.crm.callsync.data.model.DeviceContactMatch getDeviceContact() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.enjay.crm.callsync.ui.leads.LeadCallLogItemUiModel> getCallLogs() {
        return null;
    }
    
    public LeadDetailUiState() {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.enjay.crm.callsync.data.local.LeadEntity component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.enjay.crm.callsync.data.model.DeviceContactMatch component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.enjay.crm.callsync.ui.leads.LeadCallLogItemUiModel> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enjay.crm.callsync.ui.leads.LeadDetailUiState copy(boolean isLoading, @org.jetbrains.annotations.Nullable()
    com.enjay.crm.callsync.data.local.LeadEntity lead, @org.jetbrains.annotations.Nullable()
    com.enjay.crm.callsync.data.model.DeviceContactMatch deviceContact, @org.jetbrains.annotations.NotNull()
    java.util.List<com.enjay.crm.callsync.ui.leads.LeadCallLogItemUiModel> callLogs) {
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