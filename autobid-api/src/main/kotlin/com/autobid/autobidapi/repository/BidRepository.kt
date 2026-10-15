package com.autobid.autobidapi.repository

import com.autobid.autobidapi.entity.Bid
import org.springframework.data.jpa.repository.JpaRepository

interface BidRepository : JpaRepository<Bid, Long> {
    fun findByAuctionIdOrderByAmountDesc(auctionId: Long): List<Bid>
    fun findTopByAuctionIdOrderByAmountDesc(auctionId: Long): Bid?
}