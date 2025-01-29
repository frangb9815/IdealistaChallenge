package com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyListDTO

import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.PriceInfo

data class PriceInfoDTO(
    val price: PriceDTO
)

fun PriceInfoDTO.toDomain(): PriceInfo {
    return PriceInfo(
        price.toDomain()
    )
}