package com.ckgod.snowball.model

import kotlinx.serialization.Serializable

@Serializable
data class InvestmentStatusUiModel(
    val ticker: String,                    // 티커명 (예: TQQQ)
    val fullName: String?,                 // 종목 풀네임
    val currentPrice: Double,              // 현재가
    val dailyChangeRate: Double,           // 전일 대비 등락률 (%)

    // 전략 상태
    val tValue: Double,                    // 현재 T값
    val totalDivision: Int,                // 전체 분할 수 (예: 40)
    val starPercent: Double,               // 별 % (소수점 2자리)
    val phase: String,                     // 현재 구간 (전반전, 후반전 등)

    // 내 계좌 상태
    val avgPrice: Double,                  // 평균 단가
    val quantity: Int,                     // 보유 수량
    val profitRate: Double,                // 수익률 % (소수점 2자리)
    val profitAmount: Double,              // 평가 손익 금액
    val oneTimeAmount: Double,             // 1회 매수액
    val totalInvested: Double,             // 누적 투자 금액
    val realizedProfit: Double,            // 총 실현 손익

    // 환율
    val exchangeRate: Double?,              // 환율
    val capital: Double,                    // 원금
    val nextSellStarPrice: Double,         // 다음 별% 매도 가격
    val nextSellTargetPrice: Double,       // 다음 지정가% 매도 가격
    val nextBuyStarPrice: Double,          // 다음 별% 매수 가격
)
