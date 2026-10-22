package com.autobid.autobidapi.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.Duration
import java.time.Instant
import java.util.Date
import javax.crypto.SecretKey

@Service
class JwtService(
    @Value("\${jwt.secret}") secret: String,
    @Value("\${jwt.expiration-ms") expirationMs: Long
) {
    private val key: SecretKey = Keys.hmacShaKeyFor(secret.toByteArray())
    private val expiration = Duration.ofMillis(expirationMs)

    fun generate(userId: Long, email: String): String =
        Jwts.builder()
            .subject(userId.toString())
            .claim("email", email)
            .issuedAt(Date())
            .expiration(Date.from(Instant.now().plus(expiration)))
            .signWith(key)
            .compact()

    fun parse(token: String): Claims =
        Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .payload
}