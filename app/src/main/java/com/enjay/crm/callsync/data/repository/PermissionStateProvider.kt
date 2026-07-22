package com.enjay.crm.callsync.data.repository

import androidx.fragment.app.Fragment

interface PermissionStateProvider {
    fun isPermissionGranted(permission: String): Boolean
    fun markPermissionRequested(permission: String)
    fun isPermanentlyDenied(fragment: Fragment, permission: String): Boolean
}
