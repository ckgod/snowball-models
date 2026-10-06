package com.ckgod.snowball.model

import kotlinx.serialization.Serializable

/**
 * 미체결 주문 (KIS 해외주식 미체결내역 기준)
 */
@Serializable
data class OpenOrderResponse(
    val orderNo: String,                 // KIS 주문번호
    val originalOrderNo: String? = null, // 정정 주문이면 원주문번호
    val ticker: String,
    val exchange: String,                // NASD, NYSE, AMEX
    val orderSide: OrderSide,
    val orderPrice: Double,
    val orderQuantity: Int,
    val filledQuantity: Int,
    val unfilledQuantity: Int,
    val orderDate: String,               // YYYYMMDD
    val orderTime: String                // HHMMSS
)

@Serializable
data class OpenOrdersResponse(
    val orders: List<OpenOrderResponse>
)

/**
 * 정정 요청. quantity 를 생략하면 남은 미체결 수량 전체를 정정한다.
 */
@Serializable
data class ModifyOrderRequest(
    val price: Double,
    val quantity: Int? = null
)

/**
 * 정정·취소 결과. 정정이면 newOrderNo 에 새 주문번호가 온다.
 */
@Serializable
data class OrderActionResponse(
    val success: Boolean,
    val message: String,
    val newOrderNo: String? = null
)

/**
 * 수동 신규 주문.
 *
 * KIS 미국 주문 유형: 매수 LIMIT·LOO·LOC / 매도 LIMIT·MOO·LOO·MOC·LOC.
 * MOO·MOC 는 시장가라 price 를 보내지 않는다 (0).
 * exchange 를 생략하면 서버가 종목으로 추정한다 (NASD/NYSE/AMEX).
 */
@Serializable
data class PlaceOrderRequest(
    val ticker: String,
    val orderSide: OrderSide,
    val orderType: OrderType,
    val price: Double = 0.0,
    val quantity: Int,
    val exchange: String? = null
)
