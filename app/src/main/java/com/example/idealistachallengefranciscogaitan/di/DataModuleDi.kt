package com.example.idealistachallengefranciscogaitan.di

import com.example.idealistachallengefranciscogaitan.data.remote.RetrofitClient
import com.example.idealistachallengefranciscogaitan.data.remote.api.PropertyApi
import com.example.idealistachallengefranciscogaitan.data.repository.remote.PropertyDetailRepositoryImpl
import com.example.idealistachallengefranciscogaitan.data.repository.remote.PropertyListRepositoryImpl
import com.example.idealistachallengefranciscogaitan.domain.repository.remote.PropertyDetailRepository
import com.example.idealistachallengefranciscogaitan.domain.repository.remote.PropertyListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModuleDi {

    @Provides
    @Singleton
    fun providePropertyApi(): PropertyApi = RetrofitClient.api

    @Provides
    @Singleton
    fun providePropertyListRepository(api: PropertyApi): PropertyListRepository {
        return PropertyListRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providePropertyDetailRepository(api: PropertyApi): PropertyDetailRepository {
        return PropertyDetailRepositoryImpl(api)
    }

}