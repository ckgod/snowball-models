package com.ckgod.snowball.model

import kotlinx.serialization.Serializable

@Serializable
data class AccountStatusResponse(
    val totalAssetValueUsd: Double,    // 총 자산(달러 환산)
    val totalBuyingValueUsd: Double,   // 총 매입금(달러)
    val totalEvalValueUsd: Double,     // 총 평가금(달러)
    val totalProfitUsd: Double,        // 총 평가손익($)
    val totalProfitRate: Double,       // 총 수익률(%)

    val totalCashUsd: Double,          // 외화예수금
    val orderableCashUsd: Double,      // 주문가능금액
    val lockedCashUsd: Double,          // 묶인 돈(증거금)
    val holdingStocks: List<HoldingStockResponse>
)