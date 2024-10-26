package data.database.api.source

import data.database.api.entity.user.UserExposeEntity
import kotlinx.coroutines.flow.Flow

interface UserDatabaseSource {
    fun getUser(): Flow<UserExposeEntity?>
    suspend fun insert(entity: UserExposeEntity)
}
