package com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyListDTO

import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.ParkingSpace

data class ParkingSpaceDTO(
    val hasParkingSpace: Boolean,
    val isParkingSpaceIncludedInPrice: Boolean
)

fun ParkingSpaceDTO.toDomain(): ParkingSpace {
    return ParkingSpace(
        hasParkingSpace,
        isParkingSpaceIncludedInPrice
    )
}