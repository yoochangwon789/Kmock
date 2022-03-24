package com.yoochangwonspro.kmock

import android.app.Application
import com.yoochangwonspro.kmock.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class LectureApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@LectureApplication)
            modules(appModule)
        }
    }
}