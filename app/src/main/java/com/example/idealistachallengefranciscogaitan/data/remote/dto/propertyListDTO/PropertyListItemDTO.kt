package com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyListDTO

import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.FavoriteProperty
import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.PropertyListItem

data class PropertyListItemDTO(
    val address: String,
    val bathrooms: Int,
    val country: String,
    val description: String,
    val district: String,
    val exterior: Boolean,
    val features: FeaturesDTO? = null,
    val floor: String,
    val latitude: Double,
    val longitude: Double,
    val multimedia: MultimediaDTO? = null,
    val municipality: String,
    val neighborhood: String,
    val operation: String,
    val parkingSpace: ParkingSpaceDTO? = null,
    val price: Double,
    val priceInfo: PriceInfoDTO? = null,
    val propertyCode: String,
    val propertyType: String,
    val province: String,
    val rooms: Int,
    val size: Double,
    val thumbnail: String
)

fun PropertyListItemDTO.toDomain(): PropertyListItem {
    return PropertyListItem(
        completeAddress = "$address, $district, $province($country)",
        bathrooms = bathrooms,
        description = description,
        exterior = exterior,
        features = features?.toDomain(),
        floor = floor,
        latitude = latitude,
        longitude = longitude,
        multimedia = multimedia?.toDomain(),
        neighborhood = neighborhood,
        operation = operation,
        parkingSpace = parkingSpace?.toDomain(),
        priceInfo = priceInfo?.toDomain(),
        propertyCode = propertyCode,
        propertyType = propertyType,
        rooms = rooms,
        size = size,
        thumbnailUrl = thumbnail,
        favoriteProperty = FavoriteProperty(
            propertyCode,
            false,
            ""
        )

    )
}