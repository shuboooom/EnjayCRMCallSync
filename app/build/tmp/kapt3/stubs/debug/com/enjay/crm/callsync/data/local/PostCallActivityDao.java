package com.enjay.crm.callsync.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016H\'J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000e0\u00162\u0006\u0010\u0018\u001a\u00020\u000bH\'J\u0018\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00162\u0006\u0010\u001a\u001a\u00020\u000bH\'J\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006!"}, d2 = {"Lcom/enjay/crm/callsync/data/local/PostCallActivityDao;", "", "findByExternalId", "Lcom/enjay/crm/callsync/data/local/PostCallActivityEntity;", "externalId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findByServerId", "serverId", "getById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPendingPostCallActivities", "", "limit", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPostCallActivity", "activity", "(Lcom/enjay/crm/callsync/data/local/PostCallActivityEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observePendingPostCallActivityCount", "Lkotlinx/coroutines/flow/Flow;", "observePostCallActivitiesByLeadId", "leadId", "observePostCallActivityById", "activityId", "reassignLead", "", "fromLeadId", "toLeadId", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePostCallActivity", "app_debug"})
@androidx.room.Dao()
public abstract interface PostCallActivityDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertPostCallActivity(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.local.PostCallActivityEntity activity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM post_call_activities WHERE leadId = :leadId ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.enjay.crm.callsync.data.local.PostCallActivityEntity>> observePostCallActivitiesByLeadId(long leadId);
    
    @androidx.room.Query(value = "SELECT * FROM post_call_activities WHERE id = :activityId LIMIT 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.enjay.crm.callsync.data.local.PostCallActivityEntity> observePostCallActivityById(long activityId);
    
    @androidx.room.Query(value = "SELECT * FROM post_call_activities WHERE syncState != \'SYNCED\' ORDER BY updatedAt ASC LIMIT :limit")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPendingPostCallActivities(int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enjay.crm.callsync.data.local.PostCallActivityEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM post_call_activities WHERE syncState != \'SYNCED\'")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> observePendingPostCallActivityCount();
    
    @androidx.room.Query(value = "SELECT * FROM post_call_activities WHERE id = :id LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.local.PostCallActivityEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM post_call_activities WHERE serverId = :serverId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object findByServerId(@org.jetbrains.annotations.NotNull()
    java.lang.String serverId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.local.PostCallActivityEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM post_call_activities WHERE externalId = :externalId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object findByExternalId(@org.jetbrains.annotations.NotNull()
    java.lang.String externalId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enjay.crm.callsync.data.local.PostCallActivityEntity> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updatePostCallActivity(@org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.local.PostCallActivityEntity activity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE post_call_activities SET leadId = :toLeadId WHERE leadId = :fromLeadId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object reassignLead(long fromLeadId, long toLeadId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}