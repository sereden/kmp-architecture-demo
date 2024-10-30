package example

import android.app.Application
import org.koin.core.context.startKoin
import example.di.appModule
import org.koin.android.ext.koin.androidContext

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(appModule())
        }
    }
}
