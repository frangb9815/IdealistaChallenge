package com.example.idealistachallengefranciscogaitan.domain.usecase

import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.FavoriteProperty
import com.example.idealistachallengefranciscogaitan.domain.repository.local.FavoritePropertyLocalRepository
import com.example.idealistachallengefranciscogaitan.utils.ResponseState
import com.example.idealistachallengefranciscogaitan.utils.ResponseState.Companion.UNEXPECTED_ERROR
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetFavoritePropertiesUseCase @Inject constructor(
    private val repository: FavoritePropertyLocalRepository
) {
    operator fun invoke(): Flow<ResponseState<List<FavoriteProperty>>> = flow {
        try {
            emit(ResponseState.Loading())
            emit(
                ResponseState.Success(
                    data = repository.getFavoriteProperties()
                )
            )
        } catch (e: Exception) {
            emit(
                ResponseState.Error(e.message ?: UNEXPECTED_ERROR)
            )
        }
    }
}