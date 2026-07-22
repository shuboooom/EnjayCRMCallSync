package com.enjay.crm.callsync.data.repository

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class AndroidPermissionStateProvider(
    context: Context,
) : PermissionStateProvider {

    private val appContext = context.applicationContext
    private val preferences = appContext.getSharedPreferences("permission_state", Context.MODE_PRIVATE)

    override fun isPermissionGranted(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(
            appContext,
            permission,
        ) == PackageManager.PERMISSION_GRANTED
    }

    override fun markPermissionRequested(permission: String) {
        preferences.edit().putBoolean(permission, true).apply()
    }

    override fun isPermanentlyDenied(fragment: Fragment, permission: String): Boolean {
        val requestedBefore = preferences.getBoolean(permission, false)
        return requestedBefore &&
            !isPermissionGranted(permission) &&
            !fragment.shouldShowRequestPermissionRationale(permission)
    }
}
