package com.example.idealistachallengefranciscogaitan.di

import com.example.idealistachallengefranciscogaitan.data.repository.local.FavoritePropertyLocalRepositoryImpl
import com.example.idealistachallengefranciscogaitan.domain.repository.local.FavoritePropertyLocalRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindFavoritePropertyLocalRepository(
        localStorageRepositoryImpl: FavoritePropertyLocalRepositoryImpl
    ): FavoritePropertyLocalRepository
}