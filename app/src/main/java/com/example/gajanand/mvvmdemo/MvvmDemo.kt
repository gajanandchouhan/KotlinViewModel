package com.example.gajanand.mvvmdemo

import android.app.Application

class MvvmDemo : Application() {
    companion object {
        var application: Application? = null
        fun getInstance(): Application? {
            return application
        }
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }


}