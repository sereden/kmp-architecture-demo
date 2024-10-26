package data.network.api.source

import data.network.api.model.NetworkResult
import data.network.api.model.user.UserResponse

interface UserRemoteDataSource {
    suspend fun getUser(): NetworkResult<UserResponse>
}
