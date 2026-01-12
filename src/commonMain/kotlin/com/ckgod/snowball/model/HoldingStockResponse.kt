package com.ckgod.snowball.model

import kotlinx.serialization.Serializable

@Serializable
data class HoldingStockResponse(
    val ticker: String,            // 티커 (TQQQ, SOXL)
    val name: String,              // 종목명
    val quantity: Int,          // 보유 수량 (실수형, 미주는 소수점 가능)
    val avgPrice: Double,          // 내 평단가
    val currentPrice: Double,      // 현재가
    val profitRate: Double,         // 수익률
    val investedAmount: Double    // 매수 누적액
)
