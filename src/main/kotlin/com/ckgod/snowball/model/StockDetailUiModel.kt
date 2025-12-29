package com.ckgod.snowball.model

import kotlinx.serialization.Serializable

@Serializable
data class StockDetailUiModel(
    val status: InvestmentStatusUiModel?,
    val histories: List<TradeHistoryUiModel>
)
