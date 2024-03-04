package com.dicoding.githublistuser

import android.app.Application

open class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
//        startKoin {
//            androidContext(this@MyApplication)
//            modules(storageModule)
//        }
    }
}