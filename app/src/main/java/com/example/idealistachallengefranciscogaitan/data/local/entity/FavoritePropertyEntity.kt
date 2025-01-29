package com.example.idealistachallengefranciscogaitan.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.FavoriteProperty

@Entity(tableName = "favorite_properties")
data class FavoritePropertyEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "property_code") var propertyCode: String,
    @ColumnInfo(name = "date_favorite") var dateFavorite: String,
    @ColumnInfo(name = "is_favorite") var isFavorite: Boolean = false
)

fun FavoritePropertyEntity.toFavoriteProperty(): FavoriteProperty {
    return FavoriteProperty(
        propertyCode = this.propertyCode,
        isFavorite = this.isFavorite,
        favoriteDate = this.dateFavorite
    )
}
