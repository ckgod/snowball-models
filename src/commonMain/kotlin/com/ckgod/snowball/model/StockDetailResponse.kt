package com.ckgod.snowball.model

import kotlinx.serialization.Serializable

@Serializable
data class StockDetailResponse(
    val status: InvestmentStatusResponse?,
    val histories: List<TradeHistoryResponse>
)
