package com.autobid.autobidapi.service

import com.autobid.autobidapi.dto.user.CreateUserRequest
import com.autobid.autobidapi.dto.user.UserResponse
import com.autobid.autobidapi.dto.user.toResponse
import com.autobid.autobidapi.entity.User
import com.autobid.autobidapi.exception.EmailAlreadyExistsException
import com.autobid.autobidapi.exception.UserNotFoundException
import com.autobid.autobidapi.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    val userRepository: UserRepository,
    val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun createUser(request: CreateUserRequest): UserResponse {
        if (userRepository.existsByEmail(request.email)) {
            throw EmailAlreadyExistsException(request.email)
        }

        val user = User(
            email = request.email,
            passwordHash = passwordEncoder.encode(request.password)
                ?: error("Password encoder returned null"),
            displayName = request.displayName
        )

        val saved = userRepository.save(user)
        return saved.toResponse()
    }

    @Transactional(readOnly = true)
    fun getUserById(id: Long): UserResponse {
        return userRepository.findById(id)
            .orElseThrow{ UserNotFoundException(id) }
            .toResponse()
    }
}