package com.enjay.crm.callsync.ui.leads;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/enjay/crm/callsync/ui/leads/LeadCallLogAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/enjay/crm/callsync/ui/leads/LeadCallLogItemUiModel;", "Lcom/enjay/crm/callsync/ui/leads/LeadCallLogAdapter$LeadCallLogViewHolder;", "onPostCallClicked", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "LeadCallLogViewHolder", "app_debug"})
public final class LeadCallLogAdapter extends androidx.recyclerview.widget.ListAdapter<com.enjay.crm.callsync.ui.leads.LeadCallLogItemUiModel, com.enjay.crm.callsync.ui.leads.LeadCallLogAdapter.LeadCallLogViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.Long, kotlin.Unit> onPostCallClicked = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.enjay.crm.callsync.ui.leads.LeadCallLogItemUiModel> DiffCallback = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.enjay.crm.callsync.ui.leads.LeadCallLogAdapter.Companion Companion = null;
    
    public LeadCallLogAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> onPostCallClicked) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.enjay.crm.callsync.ui.leads.LeadCallLogAdapter.LeadCallLogViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.ui.leads.LeadCallLogAdapter.LeadCallLogViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/enjay/crm/callsync/ui/leads/LeadCallLogAdapter$Companion;", "", "()V", "DiffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/enjay/crm/callsync/ui/leads/LeadCallLogItemUiModel;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/enjay/crm/callsync/ui/leads/LeadCallLogAdapter$LeadCallLogViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/enjay/crm/callsync/databinding/ItemLeadCallLogBinding;", "onPostCallClicked", "Lkotlin/Function1;", "", "", "(Lcom/enjay/crm/callsync/databinding/ItemLeadCallLogBinding;Lkotlin/jvm/functions/Function1;)V", "bind", "item", "Lcom/enjay/crm/callsync/ui/leads/LeadCallLogItemUiModel;", "app_debug"})
    public static final class LeadCallLogViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.enjay.crm.callsync.databinding.ItemLeadCallLogBinding binding = null;
        @org.jetbrains.annotations.NotNull()
        private final kotlin.jvm.functions.Function1<java.lang.Long, kotlin.Unit> onPostCallClicked = null;
        
        public LeadCallLogViewHolder(@org.jetbrains.annotations.NotNull()
        com.enjay.crm.callsync.databinding.ItemLeadCallLogBinding binding, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> onPostCallClicked) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.enjay.crm.callsync.ui.leads.LeadCallLogItemUiModel item) {
        }
    }
}