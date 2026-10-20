package com.autobid.autobidapi.controller

import com.autobid.autobidapi.dto.auth.LoginRequest
import com.autobid.autobidapi.dto.auth.LoginResponse
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
class AuthController(private val authenticationManager: AuthenticationManager) {

    @PostMapping("/login")
    fun login(@Valid @RequestBody request: LoginRequest): ResponseEntity<LoginResponse> {
        authenticationManager.authenticate(UsernamePasswordAuthenticationToken(request.email, request.password))
        return ResponseEntity.ok(LoginResponse(token = "placeholder"))
    }
}