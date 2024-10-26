package test.resources

import android.app.Application
import org.koin.core.context.startKoin
import test.resources.di.appModule

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule())
        }
    }
}
