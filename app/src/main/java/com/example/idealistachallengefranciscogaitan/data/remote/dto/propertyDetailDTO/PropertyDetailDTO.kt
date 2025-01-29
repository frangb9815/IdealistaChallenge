package com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyDetailDTO

import com.example.idealistachallengefranciscogaitan.domain.model.propertyDetail.PropertyDetail

data class PropertyDetailDTO(
    val adid: Int,
    val country: String,
    val energyCertification: EnergyCertificationDetailDTO,
    val extendedPropertyType: String,
    val homeType: String,
    val moreCharacteristics: MoreCharacteristicsDetailDTO,
    val multimedia: MultimediaDetailDTO,
    val operation: String,
    val price: Double,
    val priceInfo: PriceInfoDetailDTO,
    val propertyComment: String,
    val propertyType: String,
    val state: String,
    val ubication: UbicationDetailDTO
)

fun PropertyDetailDTO.toDomain(): PropertyDetail {
    return PropertyDetail(
        adid,
        country,
        energyCertification.toDomain(),
        extendedPropertyType,
        homeType,
        moreCharacteristics.toDomain(),
        multimedia.toDomain(),
        operation,
        price,
        priceInfo.toDomain(),
        propertyComment,
        propertyType,
        state,
        ubication.toDomain()
    )
}