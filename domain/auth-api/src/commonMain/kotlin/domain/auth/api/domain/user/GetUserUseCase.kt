package domain.auth.api.domain.user

import domain.auth.api.model.user.User
import kotlinx.coroutines.flow.Flow

interface GetUserUseCase {

    suspend operator fun invoke(): Flow<Result<User>>
}
