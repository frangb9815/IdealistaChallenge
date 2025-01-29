package com.example.idealistachallengefranciscogaitan.data.repository.remote

import com.example.idealistachallengefranciscogaitan.data.remote.api.PropertyApi
import com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyListDTO.PropertyListDTO
import com.example.idealistachallengefranciscogaitan.domain.repository.remote.PropertyListRepository
import javax.inject.Inject

class PropertyListRepositoryImpl @Inject constructor(
    private val propertyApi: PropertyApi,
) : PropertyListRepository {

    override suspend fun getAllProperties(): PropertyListDTO {
        return propertyApi.getProperties()
    }
}