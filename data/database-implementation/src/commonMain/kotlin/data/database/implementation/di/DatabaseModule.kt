package data.database.implementation.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module
@ComponentScan("data.database.implementation.domain")
class DatabaseModule
