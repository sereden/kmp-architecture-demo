package data.network.implementation.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module
@ComponentScan("data.network.implementation.domain")
class NetworkModule
