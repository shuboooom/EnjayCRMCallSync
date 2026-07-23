package com.enjay.crm.callsync.sync

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.content.pm.ServiceInfo
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import com.enjay.crm.callsync.EnjayCallSyncApp
import com.enjay.crm.callsync.R
import com.enjay.crm.callsync.data.sync.SyncRunOutcome
import retrofit2.HttpException
import java.io.IOException

class SyncWorker(
    appContext: Context,
    params: WorkerParameters,
) : CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        setForeground(createForegroundInfo())
        val app = applicationContext as EnjayCallSyncApp
        val shouldRetry = runAttemptCount < MAX_RETRY_ATTEMPTS
        return try {
            when (app.appContainer.syncCoordinator.runSync()) {
                is SyncRunOutcome.Completed -> Result.success()
                SyncRunOutcome.AlreadyRunning -> {
                    if (shouldRetry) Result.retry() else Result.failure()
                }
            }
        } catch (exception: IOException) {
            if (shouldRetry) Result.retry() else Result.failure()
        } catch (exception: HttpException) {
            if (exception.code() >= 500 && shouldRetry) Result.retry() else Result.failure()
        } catch (_: Exception) {
            if (shouldRetry) Result.retry() else Result.failure()
        }
    }

    private fun createForegroundInfo(): ForegroundInfo {
        createNotificationChannel()
        val notification = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_call_24)
            .setContentTitle(applicationContext.getString(R.string.sync_worker_notification_title))
            .setContentText(applicationContext.getString(R.string.sync_worker_notification_body))
            .setOngoing(true)
            .setOnlyAlertOnce(true)
            .setProgress(0, 0, true)
            .setForegroundServiceBehavior(NotificationCompat.FOREGROUND_SERVICE_IMMEDIATE)
            .build()

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ForegroundInfo(
                NOTIFICATION_ID,
                notification,
                ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC,
            )
        } else {
            ForegroundInfo(NOTIFICATION_ID, notification)
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return
        val manager = applicationContext.getSystemService(NotificationManager::class.java) ?: return
        val channel = NotificationChannel(
            CHANNEL_ID,
            applicationContext.getString(R.string.sync_worker_channel_name),
            NotificationManager.IMPORTANCE_LOW,
        ).apply {
            description = applicationContext.getString(R.string.sync_worker_channel_description)
        }
        manager.createNotificationChannel(channel)
    }

    companion object {
        const val MAX_RETRY_ATTEMPTS = 5
        private const val CHANNEL_ID = "sync_worker"
        private const val NOTIFICATION_ID = 3001
    }
}
