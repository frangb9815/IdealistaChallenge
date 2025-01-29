package com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyDetailDTO

import com.example.idealistachallengefranciscogaitan.domain.model.propertyDetail.EnergyCertificationDetail

data class EnergyCertificationDetailDTO(
    val emissions: EmissionsDetailDTO,
    val energyConsumption: EnergyConsumptionDetailDTO,
    val title: String
)

fun EnergyCertificationDetailDTO.toDomain(): EnergyCertificationDetail {
    return EnergyCertificationDetail(
        emissions.toDomain(),
        energyConsumption.toDomain(),
        title
    )
}