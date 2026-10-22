package com.autobid.autobidapi.controller

import com.autobid.autobidapi.dto.auth.LoginRequest
import com.autobid.autobidapi.dto.auth.LoginResponse
import com.autobid.autobidapi.entity.User
import com.autobid.autobidapi.security.JwtService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(private val authenticationManager: AuthenticationManager, private val jwtService: JwtService) {

    @PostMapping("/login")
    fun login(@Valid @RequestBody request: LoginRequest): ResponseEntity<LoginResponse> {
        val auth = authenticationManager.authenticate(UsernamePasswordAuthenticationToken(request.email, request.password))

        val user = auth.principal as User
        return ResponseEntity.ok(
            LoginResponse(jwtService.generate(user.id!!, user.email))
        )
    }
}