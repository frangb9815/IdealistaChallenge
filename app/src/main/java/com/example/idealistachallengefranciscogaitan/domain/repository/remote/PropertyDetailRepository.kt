package com.example.idealistachallengefranciscogaitan.domain.repository.remote

import com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyDetailDTO.PropertyDetailDTO

interface PropertyDetailRepository {
    suspend fun getPropertyDetail(): PropertyDetailDTO
}