package com.example.idealistachallengefranciscogaitan.domain.model.propertyList

data class PropertyListItem(
    val completeAddress: String,
    val bathrooms: Int,
    val description: String,
    val exterior: Boolean,
    val features: Features? = null,
    val floor: String,
    val latitude: Double,
    val longitude: Double,
    val multimedia: Multimedia? = null,
    val neighborhood: String,
    val operation: String,
    val parkingSpace: ParkingSpace? = null,
    val priceInfo: PriceInfo? = null,
    val propertyCode: String,
    val propertyType: String,
    val rooms: Int,
    val size: Double,
    val thumbnailUrl: String,
    var favoriteProperty: FavoriteProperty? = null,
)