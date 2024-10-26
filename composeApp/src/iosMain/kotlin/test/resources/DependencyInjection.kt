package test.resources

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import test.resources.di.appModule

fun doInitDependencyFramework(): KoinApplication {
    return startKoin {
        modules(appModule())
    }
}
