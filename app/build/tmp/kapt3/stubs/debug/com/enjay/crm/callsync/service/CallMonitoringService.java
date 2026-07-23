package com.enjay.crm.callsync.service;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 H2\u00020\u0001:\u0001HB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000fH\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010)\u001a\u00020\u000fH\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0013H\u0002J\b\u0010/\u001a\u00020-H\u0002J@\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u0013H\u0002J\u0010\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u000201H\u0002J\u0014\u0010;\u001a\u0004\u0018\u00010<2\b\u0010:\u001a\u0004\u0018\u000101H\u0016J\u0010\u0010=\u001a\u00020-2\u0006\u0010)\u001a\u00020\u000fH\u0002J\b\u0010>\u001a\u00020-H\u0016J\b\u0010?\u001a\u00020-H\u0016J\"\u0010@\u001a\u00020\u000f2\b\u0010:\u001a\u0004\u0018\u0001012\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fH\u0016J\b\u0010C\u001a\u00020-H\u0002J(\u0010D\u001a\u00020-2\u0006\u0010E\u001a\u0002012\u0006\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020+2\u0006\u00103\u001a\u00020\u0013H\u0002J\b\u0010F\u001a\u00020-H\u0002J\b\u0010G\u001a\u00020-H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\b\u001a\u0004\b$\u0010%\u00a8\u0006I"}, d2 = {"Lcom/enjay/crm/callsync/service/CallMonitoringService;", "Landroid/app/Service;", "()V", "app", "Lcom/enjay/crm/callsync/EnjayCallSyncApp;", "getApp", "()Lcom/enjay/crm/callsync/EnjayCallSyncApp;", "app$delegate", "Lkotlin/Lazy;", "appContainer", "Lcom/enjay/crm/callsync/data/AppContainer;", "getAppContainer", "()Lcom/enjay/crm/callsync/data/AppContainer;", "appContainer$delegate", "currentCallState", "", "isRegistered", "", "lastProcessedCallLogId", "", "Ljava/lang/Long;", "mainHandler", "Landroid/os/Handler;", "notificationManager", "Landroid/app/NotificationManager;", "getNotificationManager", "()Landroid/app/NotificationManager;", "notificationManager$delegate", "phoneStateListener", "Landroid/telephony/PhoneStateListener;", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "telephonyCallback", "Landroid/telephony/TelephonyCallback;", "telephonyManager", "Landroid/telephony/TelephonyManager;", "getTelephonyManager", "()Landroid/telephony/TelephonyManager;", "telephonyManager$delegate", "buildServiceNotification", "Landroid/app/Notification;", "state", "callStateText", "", "captureCompletedCall", "", "referenceTime", "createNotificationChannel", "createPostCallActivityIntent", "Landroid/content/Intent;", "leadId", "leadCallLogId", "leadName", "phoneNumber", "callType", "callTimestamp", "callDurationSeconds", "launchPostCallActivityInApp", "intent", "onBind", "Landroid/os/IBinder;", "onCallStateUpdated", "onCreate", "onDestroy", "onStartCommand", "flags", "startId", "registerCallStateListenerIfNeeded", "showPostCallNotification", "activityIntent", "startForegroundInternal", "unregisterCallStateListener", "Companion", "app_debug"})
public final class CallMonitoringService extends android.app.Service {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy telephonyManager$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy notificationManager$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy app$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy appContainer$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope serviceScope = null;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler mainHandler = null;
    @org.jetbrains.annotations.Nullable()
    private android.telephony.TelephonyCallback telephonyCallback;
    @org.jetbrains.annotations.Nullable()
    private android.telephony.PhoneStateListener phoneStateListener;
    private boolean isRegistered = false;
    private int currentCallState = android.telephony.TelephonyManager.CALL_STATE_IDLE;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long lastProcessedCallLogId;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String NOTIFICATION_CHANNEL_ID = "call_monitoring";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String POST_CALL_NOTIFICATION_CHANNEL_ID = "post_call_activity";
    private static final int NOTIFICATION_ID = 4012;
    private static final int POST_CALL_NOTIFICATION_ID_BASE = 9000;
    private static final long MATCH_WINDOW_BEFORE_MS = 120000L;
    private static final long MATCH_WINDOW_AFTER_MS = 15000L;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "EnjayCallSync";
    @org.jetbrains.annotations.NotNull()
    public static final com.enjay.crm.callsync.service.CallMonitoringService.Companion Companion = null;
    
    public CallMonitoringService() {
        super();
    }
    
    private final android.telephony.TelephonyManager getTelephonyManager() {
        return null;
    }
    
    private final android.app.NotificationManager getNotificationManager() {
        return null;
    }
    
    private final com.enjay.crm.callsync.EnjayCallSyncApp getApp() {
        return null;
    }
    
    private final com.enjay.crm.callsync.data.AppContainer getAppContainer() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
        return null;
    }
    
    private final void startForegroundInternal() {
    }
    
    private final void registerCallStateListenerIfNeeded() {
    }
    
    private final void unregisterCallStateListener() {
    }
    
    private final void onCallStateUpdated(int state) {
    }
    
    private final void captureCompletedCall(long referenceTime) {
    }
    
    private final android.content.Intent createPostCallActivityIntent(long leadId, long leadCallLogId, java.lang.String leadName, java.lang.String phoneNumber, java.lang.String callType, long callTimestamp, long callDurationSeconds) {
        return null;
    }
    
    private final boolean launchPostCallActivityInApp(android.content.Intent intent) {
        return false;
    }
    
    private final void showPostCallNotification(android.content.Intent activityIntent, java.lang.String leadName, java.lang.String phoneNumber, long leadCallLogId) {
    }
    
    private final android.app.Notification buildServiceNotification(int state) {
        return null;
    }
    
    private final java.lang.String callStateText(int state) {
        return null;
    }
    
    private final void createNotificationChannel() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/enjay/crm/callsync/service/CallMonitoringService$Companion;", "", "()V", "MATCH_WINDOW_AFTER_MS", "", "MATCH_WINDOW_BEFORE_MS", "NOTIFICATION_CHANNEL_ID", "", "NOTIFICATION_ID", "", "POST_CALL_NOTIFICATION_CHANNEL_ID", "POST_CALL_NOTIFICATION_ID_BASE", "TAG", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}