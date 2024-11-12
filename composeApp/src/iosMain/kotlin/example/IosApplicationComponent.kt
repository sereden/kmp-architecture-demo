package example

import data.api.domain.source.KeystoreManager
import org.koin.dsl.module

data class IosApplicationComponent(
    private val keystore: KeystoreManager
) {
    val module = listOf(
        module {
            single<KeystoreManager> { keystore }
        }
    )
}