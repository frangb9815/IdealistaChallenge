package com.example.idealistachallengefranciscogaitan.domain.model.propertyDetail

data class PropertyDetail(
    val adid: Int,
    val country: String,
    val energyCertification: EnergyCertificationDetail,
    val extendedPropertyType: String,
    val homeType: String,
    val moreCharacteristics: MoreCharacteristicsDetail,
    val multimedia: MultimediaDetail,
    val operation: String,
    val price: Double,
    val priceInfo: PriceInfoDetail,
    val propertyComment: String,
    val propertyType: String,
    val state: String,
    val ubication: UbicationDetail
)