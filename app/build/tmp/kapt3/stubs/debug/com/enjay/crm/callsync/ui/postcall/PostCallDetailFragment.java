package com.enjay.crm.callsync.ui.postcall;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/enjay/crm/callsync/ui/postcall/PostCallDetailFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/enjay/crm/callsync/databinding/FragmentPostCallDetailBinding;", "binding", "getBinding", "()Lcom/enjay/crm/callsync/databinding/FragmentPostCallDetailBinding;", "hasShownNotFound", "", "postCallActivityId", "", "getPostCallActivityId", "()J", "viewModel", "Lcom/enjay/crm/callsync/ui/postcall/PostCallDetailViewModel;", "getViewModel", "()Lcom/enjay/crm/callsync/ui/postcall/PostCallDetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onDestroyView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_debug"})
public final class PostCallDetailFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.enjay.crm.callsync.databinding.FragmentPostCallDetailBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private boolean hasShownNotFound = false;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ARG_POST_CALL_ACTIVITY_ID = "postCallActivityId";
    @org.jetbrains.annotations.NotNull()
    public static final com.enjay.crm.callsync.ui.postcall.PostCallDetailFragment.Companion Companion = null;
    
    public PostCallDetailFragment() {
        super();
    }
    
    private final com.enjay.crm.callsync.databinding.FragmentPostCallDetailBinding getBinding() {
        return null;
    }
    
    private final long getPostCallActivityId() {
        return 0L;
    }
    
    private final com.enjay.crm.callsync.ui.postcall.PostCallDetailViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/enjay/crm/callsync/ui/postcall/PostCallDetailFragment$Companion;", "", "()V", "ARG_POST_CALL_ACTIVITY_ID", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}