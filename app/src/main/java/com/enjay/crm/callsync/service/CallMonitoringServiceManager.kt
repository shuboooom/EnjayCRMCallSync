package com.enjay.crm.callsync.service

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import com.enjay.crm.callsync.core.AppPermissions
import com.enjay.crm.callsync.data.repository.PermissionStateProvider

object CallMonitoringServiceManager {

    fun sync(
        context: Context,
        permissionStateProvider: PermissionStateProvider,
    ) {
        val serviceIntent = Intent(context, CallMonitoringService::class.java)
        val hasAllPermissions = AppPermissions.foregroundServicePermissions()
            .all(permissionStateProvider::isPermissionGranted)

        if (hasAllPermissions) {
            ContextCompat.startForegroundService(context, serviceIntent)
        } else {
            context.stopService(serviceIntent)
        }
    }
}
