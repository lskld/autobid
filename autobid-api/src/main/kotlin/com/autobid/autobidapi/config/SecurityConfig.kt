package com.autobid.autobidapi.config

import com.autobid.autobidapi.service.AppUserDetailsService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {
    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun authenticationProvider(
        userDetailsService: AppUserDetailsService,
        passwordEncoder: PasswordEncoder
    ): DaoAuthenticationProvider =
        DaoAuthenticationProvider(userDetailsService).apply {
            setPasswordEncoder(passwordEncoder)
        }

    @Bean
    fun authenticationManager(provider: DaoAuthenticationProvider): AuthenticationManager =
        ProviderManager(provider)

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain =
        http
            .csrf { it.disable() }
            .authorizeHttpRequests { it.anyRequest().permitAll() }
            .build()
}