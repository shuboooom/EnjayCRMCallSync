package com.enjay.crm.callsync.ui.postcall;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u0001:\u00018B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u0014H\u0002J\u0012\u0010/\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\b\u00102\u001a\u00020,H\u0002J\u0010\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020\fH\u0002J\b\u00105\u001a\u00020,H\u0002J\b\u00106\u001a\u00020,H\u0002J\b\u00107\u001a\u00020,H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u0019\u0010\u000eR\u001b\u0010\u001b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\b\u001a\u0004\b\u001c\u0010\u000eR\u001b\u0010\u001e\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\b\u001a\u0004\b\u001f\u0010\u0016R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\b\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010\b\u001a\u0004\b\'\u0010\u0016R\u0012\u0010)\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010*\u00a8\u00069"}, d2 = {"Lcom/enjay/crm/callsync/ui/postcall/PostCallActivityFormActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "appContainer", "Lcom/enjay/crm/callsync/data/AppContainer;", "getAppContainer", "()Lcom/enjay/crm/callsync/data/AppContainer;", "appContainer$delegate", "Lkotlin/Lazy;", "binding", "Lcom/enjay/crm/callsync/databinding/ActivityPostCallActivityFormBinding;", "callDurationSeconds", "", "getCallDurationSeconds", "()J", "callDurationSeconds$delegate", "callTimestamp", "getCallTimestamp", "callTimestamp$delegate", "callType", "", "getCallType", "()Ljava/lang/String;", "callType$delegate", "leadCallLogId", "getLeadCallLogId", "leadCallLogId$delegate", "leadId", "getLeadId", "leadId$delegate", "leadName", "getLeadName", "leadName$delegate", "notificationId", "", "getNotificationId", "()I", "notificationId$delegate", "phoneNumber", "getPhoneNumber", "phoneNumber$delegate", "selectedFollowUpAt", "Ljava/lang/Long;", "dismissLaunchNotification", "", "displayCallType", "rawValue", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "openDatePicker", "openTimePicker", "selectedDateUtc", "savePostCallActivity", "setupForm", "setupHeader", "Companion", "app_debug"})
public final class PostCallActivityFormActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.enjay.crm.callsync.databinding.ActivityPostCallActivityFormBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy appContainer$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy leadId$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy leadCallLogId$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy leadName$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy phoneNumber$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy callType$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy callTimestamp$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy callDurationSeconds$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy notificationId$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long selectedFollowUpAt;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_LEAD_ID = "leadId";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_LEAD_CALL_LOG_ID = "leadCallLogId";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_LEAD_NAME = "leadName";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_PHONE_NUMBER = "phoneNumber";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_CALL_TYPE = "callType";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_CALL_TIMESTAMP = "callTimestamp";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_CALL_DURATION_SECONDS = "callDurationSeconds";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_NOTIFICATION_ID = "notificationId";
    @org.jetbrains.annotations.NotNull()
    public static final com.enjay.crm.callsync.ui.postcall.PostCallActivityFormActivity.Companion Companion = null;
    
    public PostCallActivityFormActivity() {
        super();
    }
    
    private final com.enjay.crm.callsync.data.AppContainer getAppContainer() {
        return null;
    }
    
    private final long getLeadId() {
        return 0L;
    }
    
    private final long getLeadCallLogId() {
        return 0L;
    }
    
    private final java.lang.String getLeadName() {
        return null;
    }
    
    private final java.lang.String getPhoneNumber() {
        return null;
    }
    
    private final java.lang.String getCallType() {
        return null;
    }
    
    private final long getCallTimestamp() {
        return 0L;
    }
    
    private final long getCallDurationSeconds() {
        return 0L;
    }
    
    private final int getNotificationId() {
        return 0;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void dismissLaunchNotification() {
    }
    
    private final void setupHeader() {
    }
    
    private final void setupForm() {
    }
    
    private final void openDatePicker() {
    }
    
    private final void openTimePicker(long selectedDateUtc) {
    }
    
    private final void savePostCallActivity() {
    }
    
    private final java.lang.String displayCallType(java.lang.String rawValue) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/enjay/crm/callsync/ui/postcall/PostCallActivityFormActivity$Companion;", "", "()V", "EXTRA_CALL_DURATION_SECONDS", "", "EXTRA_CALL_TIMESTAMP", "EXTRA_CALL_TYPE", "EXTRA_LEAD_CALL_LOG_ID", "EXTRA_LEAD_ID", "EXTRA_LEAD_NAME", "EXTRA_NOTIFICATION_ID", "EXTRA_PHONE_NUMBER", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}