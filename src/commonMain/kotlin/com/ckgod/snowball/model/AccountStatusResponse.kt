package com.ckgod.snowball.model

import kotlinx.serialization.Serializable

@Serializable
data class TotalAssetResponse(
    val assets: List<AssetItemResponse>,
    val holdingStocks: List<HoldingStockResponse>,
    val exchangeRate: Double = 1450.0
)

@Serializable
data class AssetItemResponse(
    val type: AssetType,
    val purchaseAmount: Double,              // 매입금액
    val evaluationAmount: Double,            // 평가금액
    val evaluationProfitLoss: Double,        // 평가손익금액
    val creditLoanAmount: Double,            // 신용대출금액
    val realNetAssetAmount: Double,          // 실제순자산금액
    val wholeWeightRate: Double              // 전체비중율
)

enum class AssetType(val label: String) {
    STOCKS("주식"),
    FUND_MMW("펀드/MMW"),
    IMA("IMA"),
    BONDS("채권"),
    ELS_DLS("ELS/DLS"),
    WRAP("WRAP"),
    TRUST("신탁"),
    RP_PROMISSORY_NOTE("RP/발행어음"),
    OVERSEAS_STOCKS("해외주식"),
    OVERSEAS_BONDS("해외채권"),
    GOLD_SPOT("금현물"),
    CD_CP("CD/CP"),
    ELECTRONIC_SHORT_TERM_BOND("전자단기사채"),
    OTHER_COMPANY_PRODUCT("타사상품"),
    FOREIGN_ELECTRONIC_SHORT_TERM_BOND("외화전자단기사채"),
    FOREIGN_ELS_DLS("외화 ELS/DLS"),
    FOREIGN_CURRENCY("외화"),
    DEPOSIT("예수금"),
    SUBSCRIPTION_DEPOSIT("청약자예수금"),
    TOTAL("합계")
}

// TotalAssetResponse 확장 프로퍼티
val TotalAssetResponse.totalAsset: AssetItemResponse?
    get() = assets.find { it.type == AssetType.TOTAL }

val TotalAssetResponse.overseasStocksAsset: AssetItemResponse?
    get() = assets.find { it.type == AssetType.OVERSEAS_STOCKS }

val TotalAssetResponse.foreignCurrencyAsset: AssetItemResponse?
    get() = assets.find { it.type == AssetType.FOREIGN_CURRENCY }

val TotalAssetResponse.rpPromissoryNoteAsset: AssetItemResponse?
    get() = assets.find { it.type == AssetType.RP_PROMISSORY_NOTE }

/** 총 자산 평가금액 (USD) */
val TotalAssetResponse.totalAssetValueUsd: Double
    get() = totalAsset?.realNetAssetAmount ?: 0.0

/** 총 매입금액 (USD) */
val TotalAssetResponse.totalBuyingValueUsd: Double
    get() = totalAsset?.purchaseAmount ?: 0.0

/** 해외주식 평가금액 (USD) */
val TotalAssetResponse.totalEvalValueUsd: Double
    get() = overseasStocksAsset?.evaluationAmount ?: 0.0

/** 총 평가손익 (USD) */
val TotalAssetResponse.totalProfitUsd: Double
    get() = totalAsset?.evaluationProfitLoss ?: 0.0

/** 총 수익률 (%) */
val TotalAssetResponse.totalProfitRate: Double
    get() {
        val purchase = totalBuyingValueUsd
        return if (purchase > 0) (totalProfitUsd / purchase) * 100 else 0.0
    }

/** 주문가능 현금 (외화) */
val TotalAssetResponse.orderableCashUsd: Double
    get() = foreignCurrencyAsset?.evaluationAmount ?: 0.0

/** RP/발행어음 금액 */
val TotalAssetResponse.rpAmountUsd: Double
    get() = rpPromissoryNoteAsset?.evaluationAmount ?: 0.0

/** 해외주식 손익금액 (USD) */
val TotalAssetResponse.totalStockProfitUsd: Double
    get() = overseasStocksAsset?.evaluationProfitLoss ?: 0.0

/** RP 손익금액 (USD) */
val TotalAssetResponse.totalRPProfitUsd: Double
    get() = rpPromissoryNoteAsset?.evaluationProfitLoss ?: 0.0