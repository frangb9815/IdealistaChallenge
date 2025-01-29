package com.example.idealistachallengefranciscogaitan.data.remote.api

import com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyDetailDTO.PropertyDetailDTO
import com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyListDTO.PropertyListDTO
import retrofit2.http.GET

interface PropertyApi {
    @GET("list.json")
    suspend fun getProperties(): PropertyListDTO

    @GET("detail.json")
    suspend fun getPropertyDetail(): PropertyDetailDTO

}