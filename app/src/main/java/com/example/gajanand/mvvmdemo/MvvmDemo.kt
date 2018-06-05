package com.example.gajanand.mvvmdemo

import android.app.Application
import android.arch.lifecycle.ProcessLifecycleOwner
import com.example.gajanand.mvvmdemo.utils.AppObserver

class MvvmDemo : Application() {
    companion object {
        var application: MvvmDemo? = null
        fun getInstance(): MvvmDemo? {
            return application
        }
    }

    override fun onCreate() {
        super.onCreate()
        application = this
        ProcessLifecycleOwner.get().lifecycle.addObserver(AppObserver())
    }


}