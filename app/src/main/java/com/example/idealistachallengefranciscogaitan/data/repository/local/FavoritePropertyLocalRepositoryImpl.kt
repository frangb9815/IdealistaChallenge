package com.example.idealistachallengefranciscogaitan.data.repository.local

import com.example.idealistachallengefranciscogaitan.data.local.dao.FavoritePropertyDao
import com.example.idealistachallengefranciscogaitan.data.local.entity.toFavoriteProperty
import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.FavoriteProperty
import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.toFavoritePropertyEntity
import com.example.idealistachallengefranciscogaitan.domain.repository.local.FavoritePropertyLocalRepository
import javax.inject.Inject

class FavoritePropertyLocalRepositoryImpl @Inject constructor(
    private val favoritePropertyDao: FavoritePropertyDao
) : FavoritePropertyLocalRepository {

    override suspend fun saveFavoriteProperty(favoriteProperty: FavoriteProperty): Boolean {
        try {
            val result =
                favoritePropertyDao.insertFavoriteProperty(favoriteProperty.toFavoritePropertyEntity())
            return result.toInt() != -1
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }

    override suspend fun getFavoriteProperties(): List<FavoriteProperty> {
        try {
            val favoriteProperties = favoritePropertyDao.getFavoriteProperties().map { entity ->
                entity.toFavoriteProperty()
            }
            return favoriteProperties
        } catch (e: Exception) {
            e.printStackTrace()
            return emptyList()
        }
    }
}