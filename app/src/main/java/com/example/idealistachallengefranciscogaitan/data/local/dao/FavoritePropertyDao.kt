package com.example.idealistachallengefranciscogaitan.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.idealistachallengefranciscogaitan.data.local.entity.FavoritePropertyEntity

@Dao
interface FavoritePropertyDao {
    @Query("SELECT * FROM favorite_properties")
    fun getFavoriteProperties(): List<FavoritePropertyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteProperty(favoriteProperty: FavoritePropertyEntity): Long
}