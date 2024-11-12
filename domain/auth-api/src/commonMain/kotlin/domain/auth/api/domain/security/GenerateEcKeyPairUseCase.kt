package domain.auth.api.domain.security

interface GenerateEcKeyPairUseCase {
    suspend operator fun invoke(): String
}