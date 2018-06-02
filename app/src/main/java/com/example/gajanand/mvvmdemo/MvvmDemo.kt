package com.example.gajanand.mvvmdemo

import android.app.Application

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
    }


}