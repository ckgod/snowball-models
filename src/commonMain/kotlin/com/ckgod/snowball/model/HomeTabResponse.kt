package com.ckgod.snowball.model

import kotlinx.serialization.Serializable

@Serializable
data class HomeTabResponse(
    val totalProfit: Double,
    val statusList: List<InvestmentStatusResponse>
)