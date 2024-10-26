package data.api.model.user

import kotlinx.datetime.Instant

data class UserData(
    val id: String,
    val phone: String,
    val createdAt: Instant
)
