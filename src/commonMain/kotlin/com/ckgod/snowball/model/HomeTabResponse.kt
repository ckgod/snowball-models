package com.ckgod.snowball.model

import kotlinx.serialization.Serializable

@Serializable
data class HomeTabResponse(
    val statusList: List<InvestmentStatusResponse>
)