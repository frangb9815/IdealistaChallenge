package com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyListDTO

import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.Features

data class FeaturesDTO(
    val hasAirConditioning: Boolean,
    val hasBoxRoom: Boolean,
    val hasGarden: Boolean,
    val hasSwimmingPool: Boolean,
    val hasTerrace: Boolean
)

fun FeaturesDTO.toDomain(): Features {
    return Features(
        hasAirConditioning,
        hasBoxRoom,
        hasGarden,
        hasSwimmingPool,
        hasTerrace
    )
}