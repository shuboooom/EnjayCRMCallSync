package com.enjay.crm.callsync.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u000eJ\f\u0010\u000f\u001a\u00020\u0010*\u00020\rH\u0002R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/enjay/crm/callsync/data/repository/DeviceCallLogRepository;", "Lcom/enjay/crm/callsync/data/repository/CallLogRepository;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appContext", "kotlin.jvm.PlatformType", "getMostRecentCall", "Lcom/enjay/crm/callsync/data/model/CallLogItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecentCalls", "", "limit", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toCallType", "Lcom/enjay/crm/callsync/data/model/CallType;", "app_debug"})
public final class DeviceCallLogRepository implements com.enjay.crm.callsync.data.repository.CallLogRepository {
    private final android.content.Context appContext = null;
    
    public DeviceCallLogRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getRecentCalls(int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enjay.crm.callsync.data.model.CallLogItem>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getMostRecentCall(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.model.CallLogItem> $completion) {
        return null;
    }
    
    private final com.enjay.crm.callsync.data.model.CallType toCallType(int $this$toCallType) {
        return null;
    }
}