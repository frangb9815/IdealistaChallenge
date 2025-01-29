package com.example.idealistachallengefranciscogaitan.domain.usecase

import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.FavoriteProperty
import com.example.idealistachallengefranciscogaitan.domain.repository.local.FavoritePropertyLocalRepository
import com.example.idealistachallengefranciscogaitan.utils.ResponseState
import com.example.idealistachallengefranciscogaitan.utils.ResponseState.Companion.UNEXPECTED_ERROR
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SaveFavoritePropertyUseCase @Inject constructor(
    private val repository: FavoritePropertyLocalRepository
) {
    operator fun invoke(favoriteProperty: FavoriteProperty): Flow<ResponseState<Boolean>> = flow {
        try {
            emit(ResponseState.Loading())
            emit(
                ResponseState.Success(
                    data = repository.saveFavoriteProperty(favoriteProperty)
                )
            )
        } catch (e: Exception) {
            emit(
                ResponseState.Error(e.message ?: UNEXPECTED_ERROR)
            )
        }
    }
}