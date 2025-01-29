package com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyDetailDTO

import com.example.idealistachallengefranciscogaitan.domain.model.propertyDetail.MoreCharacteristicsDetail

data class MoreCharacteristicsDetailDTO(
    val agencyIsABank: Boolean,
    val bathNumber: Int,
    val boxroom: Boolean,
    val communityCosts: Double,
    val constructedArea: Int,
    val energyCertificationType: String,
    val exterior: Boolean,
    val flatLocation: String,
    val floor: String,
    val housingFurnitures: String,
    val isDuplex: Boolean,
    val lift: Boolean,
    val modificationDate: Long,
    val roomNumber: Int,
    val status: String
)

fun MoreCharacteristicsDetailDTO.toDomain(): MoreCharacteristicsDetail {
    return MoreCharacteristicsDetail(
        agencyIsABank,
        bathNumber,
        boxroom,
        communityCosts,
        constructedArea,
        energyCertificationType,
        exterior,
        flatLocation,
        floor,
        housingFurnitures,
        isDuplex,
        lift,
        modificationDate,
        roomNumber,
        status
    )
}