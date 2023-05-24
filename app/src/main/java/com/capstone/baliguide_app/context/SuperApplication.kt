package com.capstone.baliguide_app.context

import android.app.Application
import android.content.Context

class SuperApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SuperApplication.appContext = applicationContext
    }

    companion object {
        lateinit  var appContext: Context
    }
}