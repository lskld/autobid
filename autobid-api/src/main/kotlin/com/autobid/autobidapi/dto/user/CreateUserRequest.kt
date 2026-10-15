package com.autobid.autobidapi.dto.user

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateUserRequest(
    @field:NotBlank @field:Email
    val email: String,

    @field:NotBlank
    @field:Size(min = 8, max = 72)
    val password: String,

    @field:NotBlank
    @field:Size(max = 100)
    val displayName: String
)
