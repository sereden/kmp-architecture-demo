package data.network.implementation.domain.source

import data.network.api.model.NetworkResult
import org.koin.core.annotation.Factory
import org.koin.core.component.KoinComponent
import data.network.api.model.user.UserResponse
import data.network.api.source.UserRemoteDataSource
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Factory
class UserRemoteDataSourceImpl : UserRemoteDataSource, KoinComponent {
    override suspend fun getUser(): NetworkResult<UserResponse> {
        // Simulate slow network request
        delay(2.seconds)
        return NetworkResult.Success(
            UserResponse(
                id = "8dc88e5e-cd52-4885-be22-5220a4ef192f",
                phone = "+3800000000",
                createdAt = 1729953033
            )
        )
    }
}
