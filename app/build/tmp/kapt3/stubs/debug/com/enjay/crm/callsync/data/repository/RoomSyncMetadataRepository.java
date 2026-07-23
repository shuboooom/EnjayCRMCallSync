package com.enjay.crm.callsync.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096@\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\tH\u0016J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0096@\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/enjay/crm/callsync/data/repository/RoomSyncMetadataRepository;", "Lcom/enjay/crm/callsync/data/repository/SyncMetadataRepository;", "syncMetadataDao", "Lcom/enjay/crm/callsync/data/local/SyncMetadataDao;", "(Lcom/enjay/crm/callsync/data/local/SyncMetadataDao;)V", "getSyncMetadata", "Lcom/enjay/crm/callsync/data/local/SyncMetadataEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeSyncMetadata", "Lkotlinx/coroutines/flow/Flow;", "upsertSyncMetadata", "", "metadata", "(Lcom/enjay/crm/callsync/data/local/SyncMetadataEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class RoomSyncMetadataRepository implements com.enjay.crm.callsync.data.repository.SyncMetadataRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.local.SyncMetadataDao syncMetadataDao = null;
    
    public RoomSyncMetadataRepository(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.local.SyncMetadataDao syncMetadataDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.enjay.crm.callsync.data.local.SyncMetadataEntity> observeSyncMetadata() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getSyncMetadata(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.local.SyncMetadataEntity> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object upsertSyncMetadata(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.local.SyncMetadataEntity metadata, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}