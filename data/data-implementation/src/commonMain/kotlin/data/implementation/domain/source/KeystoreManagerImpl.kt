package data.implementation.domain.source

import data.api.domain.source.KeystoreManager
import data.api.model.security.KeyModel
import org.koin.core.annotation.Factory
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Factory
class KeystoreManagerImpl : KeystoreManager {
    @OptIn(ExperimentalUuidApi::class)
    override fun generateEcKeyPair(): KeyModel {
        // TODO implement Android EC Key generation using Nimbus library
        return KeyModel(
            keyId = Uuid.random().toString(),
            privateKey = "",
            publicKey = ""
        )
    }
}