package com.example.idealistachallengefranciscogaitan.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.idealistachallengefranciscogaitan.data.local.dao.FavoritePropertyDao
import com.example.idealistachallengefranciscogaitan.data.local.entity.FavoritePropertyEntity

@Database(entities = [FavoritePropertyEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoritePropertyDao(): FavoritePropertyDao
}