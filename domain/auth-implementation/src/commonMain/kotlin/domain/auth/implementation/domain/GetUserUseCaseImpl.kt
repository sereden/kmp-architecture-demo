package domain.auth.implementation.domain

import data.api.domain.repository.UserRepository
import domain.auth.api.domain.repository.GetUserUseCase
import domain.auth.api.model.user.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import org.koin.core.annotation.Factory

@Factory
class GetUserUseCaseImpl(
    private val userRepository: UserRepository
) : GetUserUseCase {
    @OptIn(FormatStringsInDatetimeFormats::class)
    override suspend fun invoke(): Flow<Result<User>> {
        return userRepository.getUser().map { result ->
            result.map { userData ->
                User(
                    id = userData.id,
                    phone = userData.phone,
                    // Apply BA rules
                    createAt = userData.createdAt.format(
                        DateTimeComponents.Format {
                            byUnicodePattern("dd.MM.yyyy")
                        }
                    )
                )
            }
        }
    }
}