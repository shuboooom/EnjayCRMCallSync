package com.enjay.crm.callsync.ui.leads;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/enjay/crm/callsync/ui/leads/LeadDetailHeaderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/enjay/crm/callsync/ui/leads/LeadDetailHeaderAdapter$ViewHolder;", "()V", "lead", "Lcom/enjay/crm/callsync/data/local/LeadEntity;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitLead", "value", "ViewHolder", "app_debug"})
public final class LeadDetailHeaderAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.enjay.crm.callsync.ui.leads.LeadDetailHeaderAdapter.ViewHolder> {
    @org.jetbrains.annotations.Nullable()
    private com.enjay.crm.callsync.data.local.LeadEntity lead;
    
    public LeadDetailHeaderAdapter() {
        super();
    }
    
    public final void submitLead(@org.jetbrains.annotations.Nullable()
    com.enjay.crm.callsync.data.local.LeadEntity value) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.enjay.crm.callsync.ui.leads.LeadDetailHeaderAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.ui.leads.LeadDetailHeaderAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/enjay/crm/callsync/ui/leads/LeadDetailHeaderAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/enjay/crm/callsync/databinding/ItemLeadDetailHeaderBinding;", "(Lcom/enjay/crm/callsync/databinding/ItemLeadDetailHeaderBinding;)V", "bind", "", "lead", "Lcom/enjay/crm/callsync/data/local/LeadEntity;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.enjay.crm.callsync.databinding.ItemLeadDetailHeaderBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.enjay.crm.callsync.databinding.ItemLeadDetailHeaderBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.enjay.crm.callsync.data.local.LeadEntity lead) {
        }
    }
}