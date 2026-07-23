package com.enjay.crm.callsync.sync

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class SyncBootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        SyncWorkScheduler.ensurePeriodicSync(context)
        SyncWorkScheduler.enqueueImmediateSync(context, "boot_completed")
    }
}
