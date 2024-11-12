package example

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import example.di.appModule

fun doInitDependencyFramework(appComponent: IosApplicationComponent): KoinApplication {
    return startKoin {
        modules(appModule() + appComponent.module)
    }
}
