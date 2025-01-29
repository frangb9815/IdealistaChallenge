package com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyDetailDTO

import com.example.idealistachallengefranciscogaitan.domain.model.propertyDetail.EnergyConsumptionDetail

data class EnergyConsumptionDetailDTO(
    val type: String
)

fun EnergyConsumptionDetailDTO.toDomain(): EnergyConsumptionDetail {
    return EnergyConsumptionDetail(
        type
    )
}