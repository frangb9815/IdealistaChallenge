package com.example.idealistachallengefranciscogaitan.domain.model.propertyList

import com.example.idealistachallengefranciscogaitan.data.local.entity.FavoritePropertyEntity

data class FavoriteProperty(
    val propertyCode: String,
    var isFavorite: Boolean = false,
    var favoriteDate: String = ""
)

fun FavoriteProperty.toFavoritePropertyEntity() : FavoritePropertyEntity {
    return FavoritePropertyEntity(
        propertyCode = this.propertyCode,
        dateFavorite = this.favoriteDate,
        isFavorite = isFavorite
    )
}