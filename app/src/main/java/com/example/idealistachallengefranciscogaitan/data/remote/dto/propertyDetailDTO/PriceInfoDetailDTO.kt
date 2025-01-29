package com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyDetailDTO

import com.example.idealistachallengefranciscogaitan.domain.model.propertyDetail.PriceInfoDetail

data class PriceInfoDetailDTO(
    val amount: Double,
    val currencySuffix: String
)

fun PriceInfoDetailDTO.toDomain(): PriceInfoDetail {
    return PriceInfoDetail(
        amount,
        currencySuffix
    )
}