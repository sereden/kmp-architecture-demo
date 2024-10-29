package example

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import example.di.appModule

fun doInitDependencyFramework(): KoinApplication {
    return startKoin {
        modules(appModule())
    }
}
