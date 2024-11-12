package data.api.domain.source

import data.api.model.security.KeyModel

interface KeystoreManager {
    fun generateEcKeyPair(): KeyModel
}