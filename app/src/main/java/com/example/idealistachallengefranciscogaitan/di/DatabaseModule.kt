package com.example.idealistachallengefranciscogaitan.di

import android.content.Context
import androidx.room.Room
import com.example.idealistachallengefranciscogaitan.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java, "favorite_properties_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideFavoritePropertyDao(db: AppDatabase) = db.favoritePropertyDao()
}