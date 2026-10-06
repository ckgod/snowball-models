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
    // 주문이 접수되지 못한 경우(REJECTED)의 사유. 구버전 응답과 호환되도록 기본값 null
    val failReason: String? = null,
    // 앱에서 직접 넣은 주문이면 true (자동매매 주문과 구분). 구버전 호환을 위해 기본값 false
    val isManual: Boolean = false,

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
    MOC("MOC"),
    LOO("LOO"),
    MOO("MOO")
}

enum class TradeStatus(val displayName: String) {
    PENDING("주문"),
    FILLED("체결"),
    CANCELED("취소"),
    PARTIAL("부분 체결"),
    REJECTED("거부")
}