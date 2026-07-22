package com.enjay.crm.callsync

import android.app.Application
import com.enjay.crm.callsync.data.AppContainer

class EnjayCallSyncApp : Application() {
    lateinit var appContainer: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(this)
    }
}
