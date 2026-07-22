package com.enjay.crm.callsync.ui.leads;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006!"}, d2 = {"Lcom/enjay/crm/callsync/ui/leads/LeadDetailFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/enjay/crm/callsync/databinding/FragmentLeadDetailBinding;", "binding", "getBinding", "()Lcom/enjay/crm/callsync/databinding/FragmentLeadDetailBinding;", "currentPhoneNumber", "", "hasShownLeadNotFound", "", "leadId", "", "getLeadId", "()J", "viewModel", "Lcom/enjay/crm/callsync/ui/leads/LeadDetailViewModel;", "getViewModel", "()Lcom/enjay/crm/callsync/ui/leads/LeadDetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onDestroyView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "openDialer", "openMessenger", "setupToolbarActions", "Companion", "app_debug"})
public final class LeadDetailFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.enjay.crm.callsync.databinding.FragmentLeadDetailBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private boolean hasShownLeadNotFound = false;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String currentPhoneNumber;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ARG_LEAD_ID = "leadId";
    @org.jetbrains.annotations.NotNull()
    public static final com.enjay.crm.callsync.ui.leads.LeadDetailFragment.Companion Companion = null;
    
    public LeadDetailFragment() {
        super();
    }
    
    private final com.enjay.crm.callsync.databinding.FragmentLeadDetailBinding getBinding() {
        return null;
    }
    
    private final long getLeadId() {
        return 0L;
    }
    
    private final com.enjay.crm.callsync.ui.leads.LeadDetailViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupToolbarActions() {
    }
    
    private final void openDialer() {
    }
    
    private final void openMessenger() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/enjay/crm/callsync/ui/leads/LeadDetailFragment$Companion;", "", "()V", "ARG_LEAD_ID", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}