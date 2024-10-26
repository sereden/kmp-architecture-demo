package data.implementation.domain.repository

import data.api.domain.repository.UserRepository
import data.api.model.user.UserData
import data.database.api.entity.user.UserExposeEntity
import data.database.api.source.UserDatabaseSource
import data.network.api.model.NetworkResult
import data.network.api.source.UserRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.onStart
import kotlinx.datetime.Instant
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Single
class UserRepositoryImpl : UserRepository, KoinComponent {
    private val userDatabaseSource: UserDatabaseSource by inject()
    private val userRemoteDataSource: UserRemoteDataSource by inject()

    override suspend fun getUser(): Flow<Result<UserData>> {
        // Implement a DataBound layer to enhance data fetching functionality
        return userDatabaseSource.getUser()
            .onStart {
                when (val remoteUser = userRemoteDataSource.getUser()) {
                    is NetworkResult.Error -> {
                        throw Exception("Can not fetch user data")
                    }
                    is NetworkResult.Success -> {
                        userDatabaseSource.insert(
                            UserExposeEntity(
                                id = remoteUser.data.id,
                                phone = remoteUser.data.phone,
                                createAt = remoteUser.data.createdAt
                            )
                        )
                    }
                }
            }
            .mapNotNull { user -> user }
            .map { entity ->
                // Final Data
                Result.success(
                    UserData(
                        id = entity.id,
                        phone = entity.phone,
                        // Convert Long to more understandable Instant
                        createdAt = Instant.fromEpochSeconds(entity.createAt)
                    )
                )
            }
            .catch {
                emit(Result.failure(it))
            }
    }
}
