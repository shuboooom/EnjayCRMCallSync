package com.enjay.crm.callsync

import android.app.Application
import com.enjay.crm.callsync.data.AppContainer
import com.enjay.crm.callsync.ui.AppVisibilityTracker

class EnjayCallSyncApp : Application() {
    lateinit var appContainer: AppContainer
        private set
    lateinit var appVisibilityTracker: AppVisibilityTracker
        private set

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(this)
        appVisibilityTracker = AppVisibilityTracker()
        registerActivityLifecycleCallbacks(appVisibilityTracker)
    }
}
