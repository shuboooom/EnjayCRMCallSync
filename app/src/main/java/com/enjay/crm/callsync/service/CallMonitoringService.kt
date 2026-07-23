@file:Suppress("DEPRECATION", "OVERRIDE_DEPRECATION")

package com.enjay.crm.callsync.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.content.pm.ServiceInfo
import android.os.Handler
import android.os.Build
import android.os.IBinder
import android.os.Looper
import android.telephony.PhoneStateListener
import android.telephony.TelephonyCallback
import android.telephony.TelephonyManager
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.getSystemService
import com.enjay.crm.callsync.EnjayCallSyncApp
import com.enjay.crm.callsync.R
import com.enjay.crm.callsync.data.local.LeadCallLogEntity
import com.enjay.crm.callsync.data.local.SyncState
import com.enjay.crm.callsync.sync.SyncWorkScheduler
import com.enjay.crm.callsync.ui.postcall.PostCallActivityFormActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CallMonitoringService : Service() {

    private val telephonyManager by lazy { getSystemService<TelephonyManager>() }
    private val notificationManager by lazy { getSystemService<NotificationManager>() }
    private val app by lazy { application as EnjayCallSyncApp }
    private val appContainer by lazy { app.appContainer }
    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val mainHandler = Handler(Looper.getMainLooper())

    private var telephonyCallback: TelephonyCallback? = null
    private var phoneStateListener: PhoneStateListener? = null
    private var isRegistered = false
    private var currentCallState = TelephonyManager.CALL_STATE_IDLE
    private val recentlyHandledCallLogIds = LinkedHashSet<Long>()

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForegroundInternal()
        registerCallStateListenerIfNeeded()
        Log.d(TAG, "onStartCommand: service started, currentCallState=$currentCallState")
        return START_STICKY
    }

    override fun onDestroy() {
        unregisterCallStateListener()
        serviceScope.cancel()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? = null

    private fun startForegroundInternal() {
        val notification = buildServiceNotification(currentCallState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            startForeground(
                NOTIFICATION_ID,
                notification,
                ServiceInfo.FOREGROUND_SERVICE_TYPE_SPECIAL_USE,
            )
        } else {
            startForeground(NOTIFICATION_ID, notification)
        }
    }

    private fun registerCallStateListenerIfNeeded() {
        val manager = telephonyManager ?: return
        if (isRegistered) return

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val callback = object : TelephonyCallback(), TelephonyCallback.CallStateListener {
                override fun onCallStateChanged(state: Int) {
                    onCallStateUpdated(state)
                }
            }
            manager.registerTelephonyCallback(mainExecutor, callback)
            telephonyCallback = callback
        } else {
            @Suppress("DEPRECATION")
            val listener = object : PhoneStateListener() {
                override fun onCallStateChanged(state: Int, phoneNumber: String?) {
                    onCallStateUpdated(state)
                }
            }
            @Suppress("DEPRECATION")
            manager.listen(listener, PhoneStateListener.LISTEN_CALL_STATE)
            phoneStateListener = listener
        }

        isRegistered = true
    }

    private fun unregisterCallStateListener() {
        val manager = telephonyManager ?: return
        if (!isRegistered) return

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            telephonyCallback?.let(manager::unregisterTelephonyCallback)
            telephonyCallback = null
        } else {
            @Suppress("DEPRECATION")
            manager.listen(phoneStateListener, PhoneStateListener.LISTEN_NONE)
            phoneStateListener = null
        }

        isRegistered = false
    }

    private fun onCallStateUpdated(state: Int) {
        if (currentCallState == state) return
        val previousState = currentCallState
        currentCallState = state
        Log.d(TAG, "onCallStateUpdated: previousState=$previousState newState=$state")
        notificationManager?.notify(NOTIFICATION_ID, buildServiceNotification(state))
        if (previousState != TelephonyManager.CALL_STATE_IDLE && state == TelephonyManager.CALL_STATE_IDLE) {
            captureCompletedCall(System.currentTimeMillis())
        }
    }

    private fun captureCompletedCall(referenceTime: Long) {
        serviceScope.launch {
            Log.d(
                TAG,
                "captureCompletedCall: referenceTime=$referenceTime recentlyHandledCallLogIds=$recentlyHandledCallLogIds",
            )
            repeat(8) { attempt ->
                if (attempt > 0) delay(1000L) else delay(1500L)
                val recentCalls = appContainer.callLogRepository.getRecentCalls(limit = RECENT_CALL_SCAN_LIMIT)
                Log.d(
                    TAG,
                    "captureCompletedCall: attempt=$attempt recentCalls=${
                        recentCalls.joinToString { "${it.id}:${it.phoneNumber}:${it.callType}:${it.timestamp}:${it.durationSeconds}" }
                    }",
                )
                val candidateCalls = recentCalls
                    .filter { it.timestamp in (referenceTime - MATCH_WINDOW_BEFORE_MS)..(referenceTime + MATCH_WINDOW_AFTER_MS) }
                    .filterNot { recentlyHandledCallLogIds.contains(it.id) }
                    .sortedBy { it.timestamp }

                if (candidateCalls.isEmpty()) {
                    Log.d(TAG, "captureCompletedCall: no unhandled candidate calls in match window on attempt=$attempt")
                    return@repeat
                }

                var insertedAny = false
                candidateCalls.forEach { call ->
                    val phoneNumber = call.phoneNumber?.trim().orEmpty()
                    if (phoneNumber.isBlank()) {
                        markCallLogHandled(call.id)
                        Log.d(TAG, "captureCompletedCall: blank phone number for callLogId=${call.id}")
                        return@forEach
                    }

                    val lead = appContainer.leadRepository.findLeadByPhoneNumber(phoneNumber)
                    if (lead == null) {
                        markCallLogHandled(call.id)
                        Log.d(TAG, "captureCompletedCall: no lead match for callLogId=${call.id} phone=$phoneNumber")
                        return@forEach
                    }

                    val startTime = call.timestamp
                    val endTime = startTime + (call.durationSeconds * 1000L)
                    val insertedId = appContainer.leadCallLogRepository.addLeadCallLog(
                        LeadCallLogEntity(
                            externalId = "call-${call.id}",
                            serverId = null,
                            syncState = SyncState.PENDING_CREATE,
                            lastSyncAttemptAt = null,
                            lastSyncedAt = null,
                            syncError = null,
                            deletedAt = null,
                            leadId = lead.id,
                            deviceCallLogId = call.id,
                            phoneNumber = phoneNumber,
                            callType = call.callType,
                            startTime = startTime,
                            endTime = endTime,
                            durationSeconds = call.durationSeconds,
                            timestamp = call.timestamp,
                            createdAt = System.currentTimeMillis(),
                            updatedAt = System.currentTimeMillis(),
                        ),
                    )
                    Log.d(
                        TAG,
                        "captureCompletedCall: insertResult=$insertedId leadId=${lead.id} callLogId=${call.id} phone=$phoneNumber",
                    )
                    markCallLogHandled(call.id)
                    if (insertedId <= 0L) return@forEach

                    insertedAny = true
                    SyncWorkScheduler.enqueueImmediateSync(this@CallMonitoringService, "call_log_saved")
                    if (call.durationSeconds <= 0L) {
                        Log.d(
                            TAG,
                            "captureCompletedCall: skipping post-call prompt for unanswered callLogId=${call.id}",
                        )
                        return@forEach
                    }

                    val launchIntent = createPostCallActivityIntent(
                        leadId = lead.id,
                        leadCallLogId = insertedId,
                        leadName = lead.name,
                        phoneNumber = phoneNumber,
                        callType = call.callType.name,
                        callTimestamp = call.timestamp,
                        callDurationSeconds = call.durationSeconds,
                    )
                    if (!launchPostCallActivityInApp(launchIntent)) {
                        showPostCallNotification(launchIntent, lead.name, phoneNumber, insertedId)
                    }
                }

                if (insertedAny) {
                    return@launch
                }
            }
            Log.d(TAG, "captureCompletedCall: exhausted attempts without insert")
        }
    }

    private fun markCallLogHandled(callLogId: Long) {
        recentlyHandledCallLogIds += callLogId
        while (recentlyHandledCallLogIds.size > MAX_HANDLED_CALL_LOG_IDS) {
            recentlyHandledCallLogIds.remove(recentlyHandledCallLogIds.first())
        }
    }

    private fun createPostCallActivityIntent(
        leadId: Long,
        leadCallLogId: Long,
        leadName: String,
        phoneNumber: String,
        callType: String,
        callTimestamp: Long,
        callDurationSeconds: Long,
    ): Intent {
        return Intent(this, PostCallActivityFormActivity::class.java).apply {
            putExtra(PostCallActivityFormActivity.EXTRA_LEAD_ID, leadId)
            putExtra(PostCallActivityFormActivity.EXTRA_LEAD_CALL_LOG_ID, leadCallLogId)
            putExtra(PostCallActivityFormActivity.EXTRA_LEAD_NAME, leadName)
            putExtra(PostCallActivityFormActivity.EXTRA_PHONE_NUMBER, phoneNumber)
            putExtra(PostCallActivityFormActivity.EXTRA_CALL_TYPE, callType)
            putExtra(PostCallActivityFormActivity.EXTRA_CALL_TIMESTAMP, callTimestamp)
            putExtra(PostCallActivityFormActivity.EXTRA_CALL_DURATION_SECONDS, callDurationSeconds)
        }
    }

    private fun launchPostCallActivityInApp(intent: Intent): Boolean {
        val activity = app.appVisibilityTracker.currentVisibleMainActivity() ?: return false
        val launchIntent = Intent(intent).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        }
        mainHandler.post {
            app.appVisibilityTracker.currentVisibleMainActivity()
                ?.takeIf { it === activity }
                ?.startActivity(launchIntent)
        }
        return true
    }

    private fun showPostCallNotification(
        activityIntent: Intent,
        leadName: String,
        phoneNumber: String,
        leadCallLogId: Long,
    ) {
        val notificationId = POST_CALL_NOTIFICATION_ID_BASE + leadCallLogId.toInt()
        val intent = Intent(activityIntent).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            putExtra(PostCallActivityFormActivity.EXTRA_NOTIFICATION_ID, notificationId)
        }
        val contentIntent = PendingIntent.getActivity(
            this,
            notificationId,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
        )
        val displayName = leadName.ifBlank { phoneNumber }
        notificationManager?.notify(
            notificationId,
            NotificationCompat.Builder(this, POST_CALL_NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_call_24)
                .setContentTitle(getString(R.string.post_call_notification_title, displayName))
                .setContentText(getString(R.string.post_call_notification_body))
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_REMINDER)
                .build(),
        )
    }

    private fun buildServiceNotification(state: Int): Notification {
        val launchIntent = packageManager.getLaunchIntentForPackage(packageName)
        val contentIntent = PendingIntent.getActivity(
            this,
            1001,
            launchIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
        )

        return NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_call_24)
            .setContentTitle(getString(R.string.call_monitor_notification_title))
            .setContentText(callStateText(state))
            .setOngoing(true)
            .setOnlyAlertOnce(true)
            .setContentIntent(contentIntent)
            .setForegroundServiceBehavior(NotificationCompat.FOREGROUND_SERVICE_IMMEDIATE)
            .build()
    }

    private fun callStateText(state: Int): String = when (state) {
        TelephonyManager.CALL_STATE_RINGING -> getString(R.string.call_monitor_status_ringing)
        TelephonyManager.CALL_STATE_OFFHOOK -> getString(R.string.call_monitor_status_offhook)
        else -> getString(R.string.call_monitor_status_idle)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return
        val manager = notificationManager ?: return
        val serviceChannel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            getString(R.string.call_monitor_channel_name),
            NotificationManager.IMPORTANCE_LOW,
        ).apply {
            description = getString(R.string.call_monitor_channel_description)
        }
        val postCallChannel = NotificationChannel(
            POST_CALL_NOTIFICATION_CHANNEL_ID,
            getString(R.string.post_call_notification_channel_name),
            NotificationManager.IMPORTANCE_HIGH,
        ).apply {
            description = getString(R.string.post_call_notification_channel_description)
        }
        manager.createNotificationChannel(serviceChannel)
        manager.createNotificationChannel(postCallChannel)
    }

    companion object {
        private const val NOTIFICATION_CHANNEL_ID = "call_monitoring"
        private const val POST_CALL_NOTIFICATION_CHANNEL_ID = "post_call_activity"
        private const val NOTIFICATION_ID = 4012
        private const val POST_CALL_NOTIFICATION_ID_BASE = 9000
        private const val RECENT_CALL_SCAN_LIMIT = 20
        private const val MAX_HANDLED_CALL_LOG_IDS = 64
        private const val MATCH_WINDOW_BEFORE_MS = 120_000L
        private const val MATCH_WINDOW_AFTER_MS = 15_000L
        private const val TAG = "EnjayCallSync"
    }
}
