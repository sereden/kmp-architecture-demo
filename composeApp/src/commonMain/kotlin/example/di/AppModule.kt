package example.di

import data.database.implementation.di.DatabaseModule
import data.implementation.di.DataModule
import data.network.implementation.di.NetworkModule
import domain.auth.implementation.di.AuthDomainModule
import org.koin.ksp.generated.module

fun appModule() = listOf(
    DataModule().module,
    DatabaseModule().module,
    NetworkModule().module,
    AuthDomainModule().module,
)
