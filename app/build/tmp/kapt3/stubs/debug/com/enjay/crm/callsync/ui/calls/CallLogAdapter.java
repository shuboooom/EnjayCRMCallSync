package com.enjay.crm.callsync.ui.calls;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \'2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005%&\'()B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0005J \u0010!\u001a\u00020\r2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\nJ \u0010#\u001a\u00020\r2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\nJ\u0014\u0010$\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/enjay/crm/callsync/ui/calls/CallLogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "actionMode", "Lcom/enjay/crm/callsync/ui/calls/CallLogAdapter$CallActionMode;", "items", "", "Lcom/enjay/crm/callsync/ui/calls/CallLogAdapter$CallLogListItem;", "onCallActionClicked", "Lkotlin/Function2;", "Lcom/enjay/crm/callsync/data/model/CallLogItem;", "Landroid/view/View;", "", "onItemClicked", "buildListItems", "calls", "getItemCount", "", "getItemViewType", "position", "headerTitle", "", "date", "Ljava/time/LocalDate;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setActionMode", "mode", "setOnCallActionClicked", "listener", "setOnItemClicked", "submitCalls", "CallActionMode", "CallLogListItem", "Companion", "EntryViewHolder", "HeaderViewHolder", "app_debug"})
public final class CallLogAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<? extends com.enjay.crm.callsync.ui.calls.CallLogAdapter.CallLogListItem> items;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function2<? super com.enjay.crm.callsync.data.model.CallLogItem, ? super android.view.View, kotlin.Unit> onCallActionClicked;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function2<? super com.enjay.crm.callsync.data.model.CallLogItem, ? super android.view.View, kotlin.Unit> onItemClicked;
    @org.jetbrains.annotations.NotNull()
    private com.enjay.crm.callsync.ui.calls.CallLogAdapter.CallActionMode actionMode = com.enjay.crm.callsync.ui.calls.CallLogAdapter.CallActionMode.MENU;
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ENTRY = 1;
    private static final java.time.format.DateTimeFormatter headerDateFormatter = null;
    private static kotlin.jvm.functions.Function1<? super java.lang.Integer, java.lang.String> contextStringProvider;
    @org.jetbrains.annotations.NotNull()
    public static final com.enjay.crm.callsync.ui.calls.CallLogAdapter.Companion Companion = null;
    
    public CallLogAdapter() {
        super();
    }
    
    public final void submitCalls(@org.jetbrains.annotations.NotNull()
    java.util.List<com.enjay.crm.callsync.data.model.CallLogItem> calls) {
    }
    
    public final void setOnCallActionClicked(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.enjay.crm.callsync.data.model.CallLogItem, ? super android.view.View, kotlin.Unit> listener) {
    }
    
    public final void setOnItemClicked(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.enjay.crm.callsync.data.model.CallLogItem, ? super android.view.View, kotlin.Unit> listener) {
    }
    
    public final void setActionMode(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.ui.calls.CallLogAdapter.CallActionMode mode) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    private final java.util.List<com.enjay.crm.callsync.ui.calls.CallLogAdapter.CallLogListItem> buildListItems(java.util.List<com.enjay.crm.callsync.data.model.CallLogItem> calls) {
        return null;
    }
    
    private final java.lang.String headerTitle(java.time.LocalDate date) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/enjay/crm/callsync/ui/calls/CallLogAdapter$CallActionMode;", "", "iconRes", "", "(Ljava/lang/String;II)V", "getIconRes", "()I", "MENU", "DIRECT_CALL", "app_debug"})
    public static enum CallActionMode {
        /*public static final*/ MENU /* = new MENU(0) */,
        /*public static final*/ DIRECT_CALL /* = new DIRECT_CALL(0) */;
        private final int iconRes = 0;
        
        CallActionMode(int iconRes) {
        }
        
        public final int getIconRes() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.enjay.crm.callsync.ui.calls.CallLogAdapter.CallActionMode> getEntries() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/enjay/crm/callsync/ui/calls/CallLogAdapter$CallLogListItem;", "", "Entry", "Header", "Lcom/enjay/crm/callsync/ui/calls/CallLogAdapter$CallLogListItem$Entry;", "Lcom/enjay/crm/callsync/ui/calls/CallLogAdapter$CallLogListItem$Header;", "app_debug"})
    public static abstract interface CallLogListItem {
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/enjay/crm/callsync/ui/calls/CallLogAdapter$CallLogListItem$Entry;", "Lcom/enjay/crm/callsync/ui/calls/CallLogAdapter$CallLogListItem;", "call", "Lcom/enjay/crm/callsync/data/model/CallLogItem;", "(Lcom/enjay/crm/callsync/data/model/CallLogItem;)V", "getCall", "()Lcom/enjay/crm/callsync/data/model/CallLogItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class Entry implements com.enjay.crm.callsync.ui.calls.CallLogAdapter.CallLogListItem {
            @org.jetbrains.annotations.NotNull()
            private final com.enjay.crm.callsync.data.model.CallLogItem call = null;
            
            public Entry(@org.jetbrains.annotations.NotNull()
            com.enjay.crm.callsync.data.model.CallLogItem call) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.enjay.crm.callsync.data.model.CallLogItem getCall() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.enjay.crm.callsync.data.model.CallLogItem component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.enjay.crm.callsync.ui.calls.CallLogAdapter.CallLogListItem.Entry copy(@org.jetbrains.annotations.NotNull()
            com.enjay.crm.callsync.data.model.CallLogItem call) {
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/enjay/crm/callsync/ui/calls/CallLogAdapter$CallLogListItem$Header;", "Lcom/enjay/crm/callsync/ui/calls/CallLogAdapter$CallLogListItem;", "title", "", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class Header implements com.enjay.crm.callsync.ui.calls.CallLogAdapter.CallLogListItem {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String title = null;
            
            public Header(@org.jetbrains.annotations.NotNull()
            java.lang.String title) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getTitle() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.enjay.crm.callsync.ui.calls.CallLogAdapter.CallLogListItem.Header copy(@org.jetbrains.annotations.NotNull()
            java.lang.String title) {
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
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/enjay/crm/callsync/ui/calls/CallLogAdapter$Companion;", "", "()V", "VIEW_TYPE_ENTRY", "", "VIEW_TYPE_HEADER", "contextStringProvider", "Lkotlin/Function1;", "", "headerDateFormatter", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "attachStringProvider", "", "provider", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void attachStringProvider(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super java.lang.Integer, java.lang.String> provider) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JN\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/enjay/crm/callsync/ui/calls/CallLogAdapter$EntryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/enjay/crm/callsync/databinding/ItemCallLogBinding;", "(Lcom/enjay/crm/callsync/databinding/ItemCallLogBinding;)V", "bind", "", "item", "Lcom/enjay/crm/callsync/data/model/CallLogItem;", "actionMode", "Lcom/enjay/crm/callsync/ui/calls/CallLogAdapter$CallActionMode;", "onCallActionClicked", "Lkotlin/Function2;", "Landroid/view/View;", "onItemClicked", "app_debug"})
    static final class EntryViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.enjay.crm.callsync.databinding.ItemCallLogBinding binding = null;
        
        public EntryViewHolder(@org.jetbrains.annotations.NotNull()
        com.enjay.crm.callsync.databinding.ItemCallLogBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.enjay.crm.callsync.data.model.CallLogItem item, @org.jetbrains.annotations.NotNull()
        com.enjay.crm.callsync.ui.calls.CallLogAdapter.CallActionMode actionMode, @org.jetbrains.annotations.Nullable()
        kotlin.jvm.functions.Function2<? super com.enjay.crm.callsync.data.model.CallLogItem, ? super android.view.View, kotlin.Unit> onCallActionClicked, @org.jetbrains.annotations.Nullable()
        kotlin.jvm.functions.Function2<? super com.enjay.crm.callsync.data.model.CallLogItem, ? super android.view.View, kotlin.Unit> onItemClicked) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/enjay/crm/callsync/ui/calls/CallLogAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/enjay/crm/callsync/databinding/ItemCallLogHeaderBinding;", "(Lcom/enjay/crm/callsync/databinding/ItemCallLogHeaderBinding;)V", "bind", "", "item", "Lcom/enjay/crm/callsync/ui/calls/CallLogAdapter$CallLogListItem$Header;", "app_debug"})
    static final class HeaderViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.enjay.crm.callsync.databinding.ItemCallLogHeaderBinding binding = null;
        
        public HeaderViewHolder(@org.jetbrains.annotations.NotNull()
        com.enjay.crm.callsync.databinding.ItemCallLogHeaderBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.enjay.crm.callsync.ui.calls.CallLogAdapter.CallLogListItem.Header item) {
        }
    }
}