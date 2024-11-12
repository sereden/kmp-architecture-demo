package data.api.model.security

data class KeyModel(
    val keyId: String,
    val privateKey: String,
    val publicKey: String
)