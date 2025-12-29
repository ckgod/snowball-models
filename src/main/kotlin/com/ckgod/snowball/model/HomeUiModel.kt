package com.ckgod.snowball.model

import kotlinx.serialization.Serializable

@Serializable
data class HomeUiModel(
    val statusList: List<InvestmentStatusUiModel>
)