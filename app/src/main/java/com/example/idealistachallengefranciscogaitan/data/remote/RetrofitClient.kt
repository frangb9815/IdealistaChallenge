package com.example.idealistachallengefranciscogaitan.data.remote

import com.example.idealistachallengefranciscogaitan.data.remote.api.PropertyApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://idealista.github.io/android-challenge/"

    val api: PropertyApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PropertyApi::class.java)
    }
}