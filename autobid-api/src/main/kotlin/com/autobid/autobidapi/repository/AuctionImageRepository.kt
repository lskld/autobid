package com.autobid.autobidapi.repository

import com.autobid.autobidapi.entity.AuctionImage
import org.springframework.data.jpa.repository.JpaRepository

interface AuctionImageRepository : JpaRepository<AuctionImage, Long> {
    fun findByAuctionId(auctionId: Long): List<AuctionImage>
    fun findFirstByAuctionIdAndIsPrimaryTrue(auctionId: Long): AuctionImage?
}