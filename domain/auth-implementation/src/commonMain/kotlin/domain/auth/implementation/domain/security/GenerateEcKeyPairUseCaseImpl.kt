package domain.auth.implementation.domain.security

import data.api.domain.repository.SecurityRepository
import domain.auth.api.domain.security.GenerateEcKeyPairUseCase
import org.koin.core.annotation.Factory
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Factory
class GenerateEcKeyPairUseCaseImpl : GenerateEcKeyPairUseCase, KoinComponent {
    private val securityRepository: SecurityRepository by inject()

    override suspend fun invoke(): String {
        return securityRepository.generateEcKey()
    }
}