package com.example.optmarket

import android.app.Application
import com.example.optmarket.di.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(this@MyApp)
            modules(allModules)
        }
    }
}