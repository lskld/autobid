package com.autobid.autobidapi.repository

import com.autobid.autobidapi.entity.Auction
import org.springframework.data.jpa.repository.JpaRepository

interface AuctionRepository : JpaRepository<Auction, Long> {
    fun findBySellerId(sellerId: Long): List<Auction>
}