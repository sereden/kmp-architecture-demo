package data.database.implementation.domain.source

import data.database.api.entity.user.UserExposeEntity
import data.database.api.source.UserDatabaseSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.core.annotation.Factory
import org.koin.core.component.KoinComponent

@Factory
class UserDatabaseSourceImpl : UserDatabaseSource, KoinComponent {
    // Emulate database
    private val database = MutableStateFlow<UserExposeEntity?>(null)

    override fun getUser(): Flow<UserExposeEntity?> {
        return database
    }

    override suspend fun insert(entity: UserExposeEntity) {
        database.emit(entity)
    }
}