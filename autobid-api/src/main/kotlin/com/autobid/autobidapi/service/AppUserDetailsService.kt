package com.autobid.autobidapi.service

import com.autobid.autobidapi.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class AppUserDetailsService (private val userRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(email: String): UserDetails =
        userRepository.findByEmail(email)
            ?: throw UsernameNotFoundException("Invalid credentials")
}