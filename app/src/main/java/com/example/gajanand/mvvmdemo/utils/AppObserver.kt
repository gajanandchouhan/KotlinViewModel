package com.example.gajanand.mvvmdemo.utils

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log

class AppObserver: LifecycleObserver{
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onForeground() {
        // App goes to foreground
        Log.v("App","foreground")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onBackground() {
        // App goes to background
        Log.v("App","onBackground")
    }
}