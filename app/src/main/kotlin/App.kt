package fr.nicopico.kmp.jsonplaceholder.android

import android.app.Application
import fr.nicopico.kmp.jsonplaceholder.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@App)
            androidLogger()
        }
    }
}
