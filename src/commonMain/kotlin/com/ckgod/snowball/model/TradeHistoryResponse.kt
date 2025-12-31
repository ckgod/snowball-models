package com.ckgod.snowball.model

import kotlinx.serialization.Serializable

@Serializable
data class TradeHistoryResponse(
    val id: Long,
    val ticker: String,

    // 주문 정보
    val orderNo: String,
    val orderSide: OrderSide,
    val orderType: OrderType,
    val orderPrice: Double,
    val orderQuantity: Int,
    val orderTime: String,
    val crashRate: Double? = null,

    // 체결 정보
    val tradeStatus: TradeStatus,
    val filledQuantity: Int,
    val filledPrice: Double,
    val filledTime: String?,

    // 전략 정보
    val tValue: Double,

    // 메타 정보
    val createdAt: String
)

enum class OrderSide(val displayName: String) {
    BUY("매수"),
    SELL("매도")
}

enum class OrderType(val displayName: String) {
    LOC("LOC"),
    LIMIT("지정가"),
    MOC("MOC")
}

enum class TradeStatus(val displayName: String) {
    PENDING("주문"),
    FILLED("체결"),
    CANCELED("취소"),
    PARTIAL("부분 체결")
}