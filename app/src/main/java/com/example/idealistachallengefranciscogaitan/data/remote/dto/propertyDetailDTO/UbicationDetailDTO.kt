package com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyDetailDTO

import com.example.idealistachallengefranciscogaitan.domain.model.propertyDetail.UbicationDetail

data class UbicationDetailDTO(
    val latitude: Double,
    val longitude: Double
)

fun UbicationDetailDTO.toDomain(): UbicationDetail {
    return UbicationDetail(
        latitude,
        longitude
    )
}