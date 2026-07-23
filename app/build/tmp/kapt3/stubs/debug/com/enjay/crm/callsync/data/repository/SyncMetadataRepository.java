package com.enjay.crm.callsync.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006H&J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/enjay/crm/callsync/data/repository/SyncMetadataRepository;", "", "getSyncMetadata", "Lcom/enjay/crm/callsync/data/local/SyncMetadataEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeSyncMetadata", "Lkotlinx/coroutines/flow/Flow;", "upsertSyncMetadata", "", "metadata", "(Lcom/enjay/crm/callsync/data/local/SyncMetadataEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface SyncMetadataRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.enjay.crm.callsync.data.local.SyncMetadataEntity> observeSyncMetadata();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSyncMetadata(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.local.SyncMetadataEntity> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object upsertSyncMetadata(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.local.SyncMetadataEntity metadata, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}