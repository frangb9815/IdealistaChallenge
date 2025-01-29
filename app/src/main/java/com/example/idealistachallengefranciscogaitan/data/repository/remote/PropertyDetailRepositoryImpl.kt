package com.example.idealistachallengefranciscogaitan.data.repository.remote

import com.example.idealistachallengefranciscogaitan.data.remote.api.PropertyApi
import com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyDetailDTO.PropertyDetailDTO
import com.example.idealistachallengefranciscogaitan.domain.repository.remote.PropertyDetailRepository
import javax.inject.Inject

class PropertyDetailRepositoryImpl @Inject constructor(
    private val propertyApi: PropertyApi,
) : PropertyDetailRepository {

    override suspend fun getPropertyDetail(): PropertyDetailDTO {
        return propertyApi.getPropertyDetail()
    }
}