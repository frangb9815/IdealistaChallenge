package com.example.idealistachallengefranciscogaitan.domain.repository.remote

import com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyListDTO.PropertyListDTO

interface PropertyListRepository {

    suspend fun getAllProperties(): PropertyListDTO
}