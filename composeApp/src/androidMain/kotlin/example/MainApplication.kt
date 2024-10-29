package example

import android.app.Application
import org.koin.core.context.startKoin
import example.di.appModule

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule())
        }
    }
}
