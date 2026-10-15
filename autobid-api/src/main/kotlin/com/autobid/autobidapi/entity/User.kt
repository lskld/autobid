package com.autobid.autobidapi.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import java.time.Instant

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long? = null,

    @Column(nullable = false, unique = true, length = 255)
    var email: String = "",

    @Column(nullable = false, length = 255)
    var passwordHash: String = "",

    @Column(nullable = false, length = 255)
    var displayName: String = "",

    @CreationTimestamp
    var createdAt: Instant? = null
)