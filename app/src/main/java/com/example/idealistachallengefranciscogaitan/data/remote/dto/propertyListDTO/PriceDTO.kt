package com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyListDTO

import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.Price

data class PriceDTO(
    val amount: Double,
    val currencySuffix: String
)

fun PriceDTO.toDomain(): Price {
    return Price(
        amount,
        currencySuffix
    )
}