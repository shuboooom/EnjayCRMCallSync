package com.enjay.crm.callsync.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u00a1\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0018J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0005H\u00c6\u0003J\t\u00104\u001a\u00020\u0011H\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\u0003H\u00c6\u0003J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\t\u0010;\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010=\u001a\u00020\bH\u00c6\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001eJ\u0010\u0010?\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001eJ\u000b\u0010@\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001eJ\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\u00cc\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010H\u001a\u00020IH\u00d6\u0001J\t\u0010J\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b&\u0010\u001eR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\'\u0010\u001eR\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001cR\u0011\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001c\u00a8\u0006K"}, d2 = {"Lcom/enjay/crm/callsync/data/local/LeadCallLogEntity;", "", "id", "", "externalId", "", "serverId", "syncState", "Lcom/enjay/crm/callsync/data/local/SyncState;", "lastSyncAttemptAt", "lastSyncedAt", "syncError", "deletedAt", "leadId", "deviceCallLogId", "phoneNumber", "callType", "Lcom/enjay/crm/callsync/data/model/CallType;", "startTime", "endTime", "durationSeconds", "timestamp", "createdAt", "updatedAt", "(JLjava/lang/String;Ljava/lang/String;Lcom/enjay/crm/callsync/data/local/SyncState;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;JJLjava/lang/String;Lcom/enjay/crm/callsync/data/model/CallType;JJJJJJ)V", "getCallType", "()Lcom/enjay/crm/callsync/data/model/CallType;", "getCreatedAt", "()J", "getDeletedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDeviceCallLogId", "getDurationSeconds", "getEndTime", "getExternalId", "()Ljava/lang/String;", "getId", "getLastSyncAttemptAt", "getLastSyncedAt", "getLeadId", "getPhoneNumber", "getServerId", "getStartTime", "getSyncError", "getSyncState", "()Lcom/enjay/crm/callsync/data/local/SyncState;", "getTimestamp", "getUpdatedAt", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;Lcom/enjay/crm/callsync/data/local/SyncState;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;JJLjava/lang/String;Lcom/enjay/crm/callsync/data/model/CallType;JJJJJJ)Lcom/enjay/crm/callsync/data/local/LeadCallLogEntity;", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
@androidx.room.Entity(tableName = "lead_call_logs", foreignKeys = {@androidx.room.ForeignKey(entity = com.enjay.crm.callsync.data.local.LeadEntity.class, parentColumns = {"id"}, childColumns = {"leadId"}, onDelete = 5)}, indices = {@androidx.room.Index(value = {"leadId"}), @androidx.room.Index(value = {"deviceCallLogId"}, unique = true), @androidx.room.Index(value = {"externalId"}, unique = true), @androidx.room.Index(value = {"serverId"}, unique = true)})
public final class LeadCallLogEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String externalId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String serverId = null;
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.local.SyncState syncState = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long lastSyncAttemptAt = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long lastSyncedAt = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String syncError = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long deletedAt = null;
    private final long leadId = 0L;
    private final long deviceCallLogId = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String phoneNumber = null;
    @org.jetbrains.annotations.NotNull()
    private final com.enjay.crm.callsync.data.model.CallType callType = null;
    private final long startTime = 0L;
    private final long endTime = 0L;
    private final long durationSeconds = 0L;
    private final long timestamp = 0L;
    private final long createdAt = 0L;
    private final long updatedAt = 0L;
    
    public LeadCallLogEntity(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String externalId, @org.jetbrains.annotations.Nullable()
    java.lang.String serverId, @org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.local.SyncState syncState, @org.jetbrains.annotations.Nullable()
    java.lang.Long lastSyncAttemptAt, @org.jetbrains.annotations.Nullable()
    java.lang.Long lastSyncedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String syncError, @org.jetbrains.annotations.Nullable()
    java.lang.Long deletedAt, long leadId, long deviceCallLogId, @org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumber, @org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.model.CallType callType, long startTime, long endTime, long durationSeconds, long timestamp, long createdAt, long updatedAt) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getExternalId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getServerId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enjay.crm.callsync.data.local.SyncState getSyncState() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getLastSyncAttemptAt() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getLastSyncedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSyncError() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getDeletedAt() {
        return null;
    }
    
    public final long getLeadId() {
        return 0L;
    }
    
    public final long getDeviceCallLogId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPhoneNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enjay.crm.callsync.data.model.CallType getCallType() {
        return null;
    }
    
    public final long getStartTime() {
        return 0L;
    }
    
    public final long getEndTime() {
        return 0L;
    }
    
    public final long getDurationSeconds() {
        return 0L;
    }
    
    public final long getTimestamp() {
        return 0L;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    public final long getUpdatedAt() {
        return 0L;
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long component10() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enjay.crm.callsync.data.model.CallType component12() {
        return null;
    }
    
    public final long component13() {
        return 0L;
    }
    
    public final long component14() {
        return 0L;
    }
    
    public final long component15() {
        return 0L;
    }
    
    public final long component16() {
        return 0L;
    }
    
    public final long component17() {
        return 0L;
    }
    
    public final long component18() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enjay.crm.callsync.data.local.SyncState component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component8() {
        return null;
    }
    
    public final long component9() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enjay.crm.callsync.data.local.LeadCallLogEntity copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String externalId, @org.jetbrains.annotations.Nullable()
    java.lang.String serverId, @org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.local.SyncState syncState, @org.jetbrains.annotations.Nullable()
    java.lang.Long lastSyncAttemptAt, @org.jetbrains.annotations.Nullable()
    java.lang.Long lastSyncedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String syncError, @org.jetbrains.annotations.Nullable()
    java.lang.Long deletedAt, long leadId, long deviceCallLogId, @org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumber, @org.jetbrains.annotations.NotNull()
    com.enjay.crm.callsync.data.model.CallType callType, long startTime, long endTime, long durationSeconds, long timestamp, long createdAt, long updatedAt) {
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