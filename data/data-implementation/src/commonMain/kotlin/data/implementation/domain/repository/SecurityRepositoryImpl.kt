package data.implementation.domain.repository

import data.api.domain.repository.SecurityRepository
import data.api.domain.source.KeystoreManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.annotation.Factory
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Factory
class SecurityRepositoryImpl : SecurityRepository, KoinComponent {
    private val keystoreManager: KeystoreManager by inject()

    override suspend fun generateEcKey() = withContext(Dispatchers.Default) {
        val ecKey = keystoreManager.generateEcKeyPair()
        println("The key is generated")
        ecKey.keyId
    }
}