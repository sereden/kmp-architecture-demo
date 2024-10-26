package data.implementation.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module
@ComponentScan("data.implementation.domain")
class DataModule
