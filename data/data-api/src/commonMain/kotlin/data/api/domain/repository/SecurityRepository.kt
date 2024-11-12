package data.api.domain.repository

interface SecurityRepository {
    suspend fun generateEcKey(): String
}