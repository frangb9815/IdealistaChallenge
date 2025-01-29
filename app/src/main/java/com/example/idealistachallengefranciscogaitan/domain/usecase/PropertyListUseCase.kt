package com.example.idealistachallengefranciscogaitan.domain.usecase

import com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyListDTO.toDomain
import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.PropertyListItem
import com.example.idealistachallengefranciscogaitan.domain.repository.remote.PropertyListRepository
import com.example.idealistachallengefranciscogaitan.utils.ResponseState
import com.example.idealistachallengefranciscogaitan.utils.ResponseState.Companion.INTERNET_ERROR
import com.example.idealistachallengefranciscogaitan.utils.ResponseState.Companion.SERVER_DEFAULT_ERROR
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PropertyListUseCase @Inject constructor(
    private val repository: PropertyListRepository
) {
    operator fun invoke(): Flow<ResponseState<List<PropertyListItem>>> = flow {
        try {
            emit(ResponseState.Loading())
            val properties = repository.getAllProperties().map {
                it.toDomain()
            }
            emit(ResponseState.Success(properties))
        } catch (e: HttpException) {
            emit(
                ResponseState.Error(e.localizedMessage ?: SERVER_DEFAULT_ERROR)
            )
        } catch (e: IOException) {
            emit(
                ResponseState.Error(INTERNET_ERROR)
            )
        }
    }
}