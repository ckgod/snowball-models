package com.ckgod.snowball.model

import kotlinx.serialization.Serializable

/**
 * 주식 가격 히스토리 응답 모델
 *
 * 백테스팅 및 차트용 가격 데이터
 */
@Serializable
data class StockPriceHistoryResponse(
    val ticker: String,
    val prices: List<PriceData>
)

@Serializable
data class PriceData(
    val date: String,           // YYYY-MM-DD 형식
    val open: Double,           // 시가
    val high: Double,           // 고가
    val low: Double,            // 저가
    val close: Double,          // 종가
    val adjClose: Double,       // 조정 종가 (배당/분할 반영)
    val volume: Long            // 거래량
)
