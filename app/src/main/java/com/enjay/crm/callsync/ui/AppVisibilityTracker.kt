package com.enjay.crm.callsync.ui

import android.app.Activity
import android.app.Application
import android.os.Bundle
import java.lang.ref.WeakReference

class AppVisibilityTracker : Application.ActivityLifecycleCallbacks {

    @Volatile
    private var currentMainActivityRef: WeakReference<MainActivity>? = null

    fun currentVisibleMainActivity(): MainActivity? {
        return currentMainActivityRef?.get()
            ?.takeIf { !it.isFinishing && !it.isDestroyed }
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) = Unit

    override fun onActivityStarted(activity: Activity) = Unit

    override fun onActivityResumed(activity: Activity) {
        if (activity is MainActivity) {
            currentMainActivityRef = WeakReference(activity)
        }
    }

    override fun onActivityPaused(activity: Activity) {
        if (activity is MainActivity && currentMainActivityRef?.get() === activity) {
            currentMainActivityRef = null
        }
    }

    override fun onActivityStopped(activity: Activity) = Unit

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) = Unit

    override fun onActivityDestroyed(activity: Activity) {
        if (activity is MainActivity && currentMainActivityRef?.get() === activity) {
            currentMainActivityRef = null
        }
    }
}
