package com.example.practicekt.activity

import android.app.Application
import timber.log.Timber

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
        Timber.d("Timber is initialized")
        Timber.tag("MyApplication").d("Application started")

        try {
            throw Exception("Test Exception")
        } catch (e: Exception) {
            Timber.e(e, "Testing Timber error logging")
        }
    }
}