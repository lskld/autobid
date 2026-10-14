package com.autobid.autobidapi.entity

import com.autobid.autobidapi.entity.enum.AuctionStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.hibernate.annotations.CreationTimestamp
import java.math.BigDecimal
import java.time.Instant

@Entity
class Auction(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long? = null,

    @Column(nullable = false, length = 255)
    var title: String = "",

    @Column(columnDefinition = "TEXT")
    var description: String? = null,

    @Column(nullable = false)
    var startPrice: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false)
    var minBidIncrement: BigDecimal = BigDecimal.ZERO,

    @CreationTimestamp
    var startTime: Instant? = null,

    @Column(nullable = false)
    var endTime: Instant? = null,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    var status: AuctionStatus = AuctionStatus.ACTIVE,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seller_id", nullable = false)
    var seller: User? = null,
)