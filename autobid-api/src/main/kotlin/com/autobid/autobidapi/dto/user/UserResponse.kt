package com.autobid.autobidapi.dto.user

import com.autobid.autobidapi.entity.User

data class UserResponse(
    val id: Long,
    val email: String,
    val displayName: String
)

fun User.toResponse() = UserResponse(
    id = id!!,
    email = email,
    displayName = displayName
)
