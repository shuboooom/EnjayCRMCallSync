package com.enjay.crm.callsync.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00a6@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/enjay/crm/callsync/data/repository/CallLogRepository;", "", "getMostRecentCall", "Lcom/enjay/crm/callsync/data/model/CallLogItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecentCalls", "", "limit", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface CallLogRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecentCalls(int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enjay.crm.callsync.data.model.CallLogItem>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMostRecentCall(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.model.CallLogItem> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}