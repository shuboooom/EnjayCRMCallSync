package com.enjay.crm.callsync.core

import android.Manifest
import android.os.Build

object AppPermissions {

    fun requiredPermissions(): List<String> = buildList {
        add(Manifest.permission.READ_CALL_LOG)
        add(Manifest.permission.READ_CONTACTS)
        add(Manifest.permission.READ_PHONE_STATE)
        add(Manifest.permission.CALL_PHONE)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            add(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    fun foregroundServicePermissions(): List<String> = buildList {
        add(Manifest.permission.READ_PHONE_STATE)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            add(Manifest.permission.POST_NOTIFICATIONS)
        }
    }
}
