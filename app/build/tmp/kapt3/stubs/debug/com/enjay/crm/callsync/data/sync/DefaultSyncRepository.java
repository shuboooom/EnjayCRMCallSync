package com.enjay.crm.callsync.data.sync;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 V2\u00020\u0001:\u0001VB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@\u00a2\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0015H\u0082@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0018H\u0082@\u00a2\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001a\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001a\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J,\u0010!\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\u001f2\b\u0010$\u001a\u0004\u0018\u00010\u001fH\u0082@\u00a2\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\'H\u0082@\u00a2\u0006\u0002\u0010(J\u0018\u0010)\u001a\u0004\u0018\u00010\u001f2\u0006\u0010*\u001a\u00020\nH\u0082@\u00a2\u0006\u0002\u0010+JB\u0010,\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001f0/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001b0/2\f\u00101\u001a\b\u0012\u0004\u0012\u00020 0/2\b\u00102\u001a\u0004\u0018\u00010\nH\u0082@\u00a2\u0006\u0002\u00103J\u0010\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010605H\u0016J\u000e\u00107\u001a\u000208H\u0082@\u00a2\u0006\u0002\u0010(J\u0016\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\'H\u0082@\u00a2\u0006\u0002\u0010<J\u001a\u0010=\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u0002080>H\u0096@\u00a2\u0006\u0002\u0010(J\u0018\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020\u001bH\u0082@\u00a2\u0006\u0002\u0010BJ\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u001fH\u0002J\u0018\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u00020 H\u0082@\u00a2\u0006\u0002\u0010IJ4\u0010J\u001a\u00020-2\u0006\u0010;\u001a\u00020\'2\u0006\u0010K\u001a\u00020\n2\b\u0010L\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010NH\u0082@\u00a2\u0006\u0002\u0010OJ\u0013\u0010P\u001a\u0004\u0018\u00010N*\u00020\u0012H\u0002\u00a2\u0006\u0002\u0010QJ\u0013\u0010P\u001a\u0004\u0018\u00010N*\u00020\u0015H\u0002\u00a2\u0006\u0002\u0010RJ\u0013\u0010P\u001a\u0004\u0018\u00010N*\u00020\u0018H\u0002\u00a2\u0006\u0002\u0010SJ\f\u0010T\u001a\u000206*\u00020\'H\u0002J\u0012\u0010U\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\n0/H\u0002R\u0014\u0010\f\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006W"}, d2 = {"Lcom/enjay/crm/callsync/data/sync/DefaultSyncRepository;", "Lcom/enjay/crm/callsync/data/sync/SyncRepository;", "database", "Lcom/enjay/crm/callsync/data/local/AppDatabase;", "syncApi", "Lcom/enjay/crm/callsync/data/sync/SyncApi;", "syncMetadataRepository", "Lcom/enjay/crm/callsync/data/repository/SyncMetadataRepository;", "deviceIdProvider", "Lkotlin/Function0;", "", "(Lcom/enjay/crm/callsync/data/local/AppDatabase;Lcom/enjay/crm/callsync/data/sync/SyncApi;Lcom/enjay/crm/callsync/data/repository/SyncMetadataRepository;Lkotlin/jvm/functions/Function0;)V", "currentDeviceId", "getCurrentDeviceId", "()Ljava/lang/String;", "applyLeadCallLogPull", "", "remote", "Lcom/enjay/crm/callsync/data/sync/LeadCallLogPullDto;", "(Lcom/enjay/crm/callsync/data/sync/LeadCallLogPullDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyLeadPull", "Lcom/enjay/crm/callsync/data/sync/LeadPullDto;", "(Lcom/enjay/crm/callsync/data/sync/LeadPullDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyPostCallActivityPull", "Lcom/enjay/crm/callsync/data/sync/PostCallActivityPullDto;", "(Lcom/enjay/crm/callsync/data/sync/PostCallActivityPullDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyPushResult", "Lcom/enjay/crm/callsync/data/local/LeadCallLogEntity;", "current", "result", "Lcom/enjay/crm/callsync/data/sync/PushResultItemDto;", "Lcom/enjay/crm/callsync/data/local/LeadEntity;", "Lcom/enjay/crm/callsync/data/local/PostCallActivityEntity;", "consolidateLeadIfNeeded", "remoteLeadId", "localByIdentity", "localByPhone", "(Ljava/lang/String;Lcom/enjay/crm/callsync/data/local/LeadEntity;Lcom/enjay/crm/callsync/data/local/LeadEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureMetadata", "Lcom/enjay/crm/callsync/data/local/SyncMetadataEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findLocalLeadByPhone", "phoneNumber", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markRetryable", "", "leads", "", "callLogs", "activities", "message", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeSyncCursorState", "Lkotlinx/coroutines/flow/Flow;", "Lcom/enjay/crm/callsync/data/sync/SyncCursorState;", "pullRemoteChanges", "Lcom/enjay/crm/callsync/data/sync/PullResultDto;", "pushPendingChanges", "Lcom/enjay/crm/callsync/data/sync/PushResultDto;", "metadata", "(Lcom/enjay/crm/callsync/data/local/SyncMetadataEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runSync", "Lkotlin/Pair;", "toLeadCallLogPushDto", "Lcom/enjay/crm/callsync/data/sync/LeadCallLogPushDto;", "callLog", "(Lcom/enjay/crm/callsync/data/local/LeadCallLogEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toLeadPushDto", "Lcom/enjay/crm/callsync/data/sync/LeadPushDto;", "lead", "toPostCallActivityPushDto", "Lcom/enjay/crm/callsync/data/sync/PostCallActivityPushDto;", "activity", "(Lcom/enjay/crm/callsync/data/local/PostCallActivityEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSyncStatus", "status", "error", "startedAt", "", "(Lcom/enjay/crm/callsync/data/local/SyncMetadataEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "localSourceIdForThisDevice", "(Lcom/enjay/crm/callsync/data/sync/LeadCallLogPullDto;)Ljava/lang/Long;", "(Lcom/enjay/crm/callsync/data/sync/LeadPullDto;)Ljava/lang/Long;", "(Lcom/enjay/crm/callsync/data/sync/PostCallActivityPullDto;)Ljava/lang/Long;", "toCursorState", "toLookupKeyBlob", "Companion", "app_debug"})
public final class DefaultSyncRepository implements com.enjay.crm.callsync.data.sync.SyncRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.local.AppDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.sync.SyncApi syncApi = null;
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.repository.SyncMetadataRepository syncMetadataRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<java.lang.String> deviceIdProvider = null;
    private static final int BATCH_SIZE = 50;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String APP_VERSION = "1.0";
    private static final int PULL_LIMIT = 100;
    private static final int MAX_PUSH_BATCHES = 10;
    private static final int MAX_PULL_BATCHES = 10;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String SOURCE_ANDROID = "android";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String STATUS_IDLE = "IDLE";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String STATUS_RUNNING = "RUNNING";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String STATUS_SUCCESS = "SUCCESS";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String STATUS_FAILED = "FAILED";
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> ENTITY_TYPES = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.enjay.crm.callsync.data.sync.DefaultSyncRepository.Companion Companion = null;
    
    public DefaultSyncRepository(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.local.AppDatabase database, @org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.sync.SyncApi syncApi, @org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.repository.SyncMetadataRepository syncMetadataRepository, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.lang.String> deviceIdProvider) {
        super();
    }
    
    private final java.lang.String getCurrentDeviceId() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.enjay.crm.callsync.data.sync.SyncCursorState> observeSyncCursorState() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object runSync(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Pair<com.enjay.crm.callsync.data.sync.PushResultDto, com.enjay.crm.callsync.data.sync.PullResultDto>> $completion) {
        return null;
    }
    
    private final java.lang.Object ensureMetadata(kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.local.SyncMetadataEntity> $completion) {
        return null;
    }
    
    private final java.lang.Object updateSyncStatus(com.enjay.crm.callsync.data.local.SyncMetadataEntity metadata, java.lang.String status, java.lang.String error, java.lang.Long startedAt, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object pushPendingChanges(com.enjay.crm.callsync.data.local.SyncMetadataEntity metadata, kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.sync.PushResultDto> $completion) {
        return null;
    }
    
    private final java.lang.Object pullRemoteChanges(kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.sync.PullResultDto> $completion) {
        return null;
    }
    
    private final java.lang.Object markRetryable(java.util.List<com.enjay.crm.callsync.data.local.LeadEntity> leads, java.util.List<com.enjay.crm.callsync.data.local.LeadCallLogEntity> callLogs, java.util.List<com.enjay.crm.callsync.data.local.PostCallActivityEntity> activities, java.lang.String message, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object applyLeadPull(com.enjay.crm.callsync.data.sync.LeadPullDto remote, kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    private final java.lang.Object findLocalLeadByPhone(java.lang.String phoneNumber, kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.local.LeadEntity> $completion) {
        return null;
    }
    
    private final java.lang.Object consolidateLeadIfNeeded(java.lang.String remoteLeadId, com.enjay.crm.callsync.data.local.LeadEntity localByIdentity, com.enjay.crm.callsync.data.local.LeadEntity localByPhone, kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.local.LeadEntity> $completion) {
        return null;
    }
    
    private final java.lang.Object applyLeadCallLogPull(com.enjay.crm.callsync.data.sync.LeadCallLogPullDto remote, kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    private final java.lang.Object applyPostCallActivityPull(com.enjay.crm.callsync.data.sync.PostCallActivityPullDto remote, kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    private final java.lang.Object toLeadCallLogPushDto(com.enjay.crm.callsync.data.local.LeadCallLogEntity callLog, kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.sync.LeadCallLogPushDto> $completion) {
        return null;
    }
    
    private final java.lang.Object toPostCallActivityPushDto(com.enjay.crm.callsync.data.local.PostCallActivityEntity activity, kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.sync.PostCallActivityPushDto> $completion) {
        return null;
    }
    
    private final com.enjay.crm.callsync.data.sync.LeadPushDto toLeadPushDto(com.enjay.crm.callsync.data.local.LeadEntity lead) {
        return null;
    }
    
    private final com.enjay.crm.callsync.data.local.LeadEntity applyPushResult(com.enjay.crm.callsync.data.local.LeadEntity current, com.enjay.crm.callsync.data.sync.PushResultItemDto result) {
        return null;
    }
    
    private final com.enjay.crm.callsync.data.local.LeadCallLogEntity applyPushResult(com.enjay.crm.callsync.data.local.LeadCallLogEntity current, com.enjay.crm.callsync.data.sync.PushResultItemDto result) {
        return null;
    }
    
    private final com.enjay.crm.callsync.data.local.PostCallActivityEntity applyPushResult(com.enjay.crm.callsync.data.local.PostCallActivityEntity current, com.enjay.crm.callsync.data.sync.PushResultItemDto result) {
        return null;
    }
    
    private final com.enjay.crm.callsync.data.sync.SyncCursorState toCursorState(com.enjay.crm.callsync.data.local.SyncMetadataEntity $this$toCursorState) {
        return null;
    }
    
    private final java.lang.String toLookupKeyBlob(java.util.List<java.lang.String> $this$toLookupKeyBlob) {
        return null;
    }
    
    private final java.lang.Long localSourceIdForThisDevice(com.enjay.crm.callsync.data.sync.LeadPullDto $this$localSourceIdForThisDevice) {
        return null;
    }
    
    private final java.lang.Long localSourceIdForThisDevice(com.enjay.crm.callsync.data.sync.LeadCallLogPullDto $this$localSourceIdForThisDevice) {
        return null;
    }
    
    private final java.lang.Long localSourceIdForThisDevice(com.enjay.crm.callsync.data.sync.PostCallActivityPullDto $this$localSourceIdForThisDevice) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/enjay/crm/callsync/data/sync/DefaultSyncRepository$Companion;", "", "()V", "APP_VERSION", "", "BATCH_SIZE", "", "ENTITY_TYPES", "", "MAX_PULL_BATCHES", "MAX_PUSH_BATCHES", "PULL_LIMIT", "SOURCE_ANDROID", "STATUS_FAILED", "STATUS_IDLE", "STATUS_RUNNING", "STATUS_SUCCESS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}