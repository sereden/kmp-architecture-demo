package data.api.domain.repository

import data.api.model.user.UserData
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun getUser(): Flow<Result<UserData>>
}
