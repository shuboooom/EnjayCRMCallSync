package com.enjay.crm.callsync.data.sync;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0004\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/enjay/crm/callsync/data/sync/SyncApi;", "", "pull", "Lcom/enjay/crm/callsync/data/sync/PullResponseDto;", "request", "Lcom/enjay/crm/callsync/data/sync/PullRequestDto;", "(Lcom/enjay/crm/callsync/data/sync/PullRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "push", "Lcom/enjay/crm/callsync/data/sync/PushResponseDto;", "Lcom/enjay/crm/callsync/data/sync/PushRequestDto;", "(Lcom/enjay/crm/callsync/data/sync/PushRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface SyncApi {
    
    @retrofit2.http.POST(value = "api/sync/push")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object push(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.sync.PushRequestDto request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.sync.PushResponseDto> $completion);
    
    @retrofit2.http.POST(value = "api/sync/pull")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object pull(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.sync.PullRequestDto request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.sync.PullResponseDto> $completion);
}