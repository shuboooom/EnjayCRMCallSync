@file:Suppress("DEPRECATION", "OVERRIDE_DEPRECATION")

package com.enjay.crm.callsync.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.content.pm.ServiceInfo
import android.os.Build
import android.os.IBinder
import android.telephony.PhoneStateListener
import android.telephony.TelephonyCallback
import android.telephony.TelephonyManager
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.getSystemService
import com.enjay.crm.callsync.EnjayCallSyncApp
import com.enjay.crm.callsync.R
import com.enjay.crm.callsync.data.local.LeadCallLogEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CallMonitoringService : Service() {

    private val telephonyManager by lazy { getSystemService<TelephonyManager>() }
    private val notificationManager by lazy { getSystemService<NotificationManager>() }
    private val appContainer by lazy { (application as EnjayCallSyncApp).appContainer }
    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    private var telephonyCallback: TelephonyCallback? = null
    private var phoneStateListener: PhoneStateListener? = null
    private var isRegistered = false
    private var currentCallState = TelephonyManager.CALL_STATE_IDLE
    private var lastProcessedCallLogId: Long? = null

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
        val notification = buildNotification(currentCallState)
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
        notificationManager?.notify(NOTIFICATION_ID, buildNotification(state))
        if (previousState != TelephonyManager.CALL_STATE_IDLE && state == TelephonyManager.CALL_STATE_IDLE) {
            captureCompletedCall(System.currentTimeMillis())
        }
    }

    private fun captureCompletedCall(referenceTime: Long) {
        serviceScope.launch {
            Log.d(TAG, "captureCompletedCall: referenceTime=$referenceTime lastProcessedCallLogId=$lastProcessedCallLogId")
            repeat(8) { attempt ->
                if (attempt > 0) delay(1000L) else delay(1500L)
                val recentCalls = appContainer.callLogRepository.getRecentCalls(limit = 5)
                Log.d(
                    TAG,
                    "captureCompletedCall: attempt=$attempt recentCalls=${
                        recentCalls.joinToString { "${it.id}:${it.phoneNumber}:${it.callType}:${it.timestamp}:${it.durationSeconds}" }
                    }",
                )
                val latestCall = recentCalls.firstOrNull()
                if (latestCall == null) {
                    Log.d(TAG, "captureCompletedCall: no recent call found on attempt=$attempt")
                    return@repeat
                }
                if (lastProcessedCallLogId == latestCall.id) {
                    Log.d(TAG, "captureCompletedCall: skipping already processed callLogId=${latestCall.id}")
                    return@repeat
                }

                val phoneNumber = latestCall.phoneNumber?.trim().orEmpty()
                if (phoneNumber.isBlank()) {
                    Log.d(TAG, "captureCompletedCall: blank phone number for callLogId=${latestCall.id}")
                    return@repeat
                }
                if (latestCall.timestamp !in (referenceTime - MATCH_WINDOW_BEFORE_MS)..(referenceTime + MATCH_WINDOW_AFTER_MS)) {
                    Log.d(
                        TAG,
                        "captureCompletedCall: latest call outside window callLogId=${latestCall.id} callTs=${latestCall.timestamp} reference=$referenceTime",
                    )
                    return@repeat
                }

                val lead = appContainer.leadRepository.findLeadByPhoneNumber(phoneNumber)
                if (lead == null) {
                    Log.d(TAG, "captureCompletedCall: no lead match for callLogId=${latestCall.id} phone=$phoneNumber")
                    return@repeat
                }

                val startTime = latestCall.timestamp
                val endTime = startTime + (latestCall.durationSeconds * 1000L)
                val inserted = appContainer.leadCallLogRepository.addLeadCallLog(
                    LeadCallLogEntity(
                        leadId = lead.id,
                        deviceCallLogId = latestCall.id,
                        phoneNumber = phoneNumber,
                        callType = latestCall.callType,
                        startTime = startTime,
                        endTime = endTime,
                        durationSeconds = latestCall.durationSeconds,
                        timestamp = latestCall.timestamp,
                        createdAt = System.currentTimeMillis(),
                    ),
                )
                Log.d(
                    TAG,
                    "captureCompletedCall: insertResult=$inserted leadId=${lead.id} callLogId=${latestCall.id} phone=$phoneNumber",
                )
                if (inserted) {
                    lastProcessedCallLogId = latestCall.id
                    return@launch
                }
            }
            Log.d(TAG, "captureCompletedCall: exhausted attempts without insert")
        }
    }

    private fun buildNotification(state: Int): Notification {
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
        val channel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            getString(R.string.call_monitor_channel_name),
            NotificationManager.IMPORTANCE_LOW,
        ).apply {
            description = getString(R.string.call_monitor_channel_description)
        }
        manager.createNotificationChannel(channel)
    }

    companion object {
        private const val NOTIFICATION_CHANNEL_ID = "call_monitoring"
        private const val NOTIFICATION_ID = 4012
        private const val MATCH_WINDOW_BEFORE_MS = 120_000L
        private const val MATCH_WINDOW_AFTER_MS = 15_000L
        private const val TAG = "EnjayCallSync"
    }
}
