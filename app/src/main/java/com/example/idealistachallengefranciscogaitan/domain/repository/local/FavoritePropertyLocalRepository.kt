package com.example.idealistachallengefranciscogaitan.domain.repository.local

import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.FavoriteProperty

interface FavoritePropertyLocalRepository {
    suspend fun saveFavoriteProperty(favoriteProperty: FavoriteProperty): Boolean
    suspend fun getFavoriteProperties(): List<FavoriteProperty>
}