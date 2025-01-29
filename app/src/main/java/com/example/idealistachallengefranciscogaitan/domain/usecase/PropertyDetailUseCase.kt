package com.example.idealistachallengefranciscogaitan.domain.usecase

import com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyDetailDTO.toDomain
import com.example.idealistachallengefranciscogaitan.domain.model.propertyDetail.PropertyDetail
import com.example.idealistachallengefranciscogaitan.domain.repository.remote.PropertyDetailRepository
import com.example.idealistachallengefranciscogaitan.utils.ResponseState
import com.example.idealistachallengefranciscogaitan.utils.ResponseState.Companion.INTERNET_ERROR
import com.example.idealistachallengefranciscogaitan.utils.ResponseState.Companion.SERVER_DEFAULT_ERROR
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PropertyDetailUseCase @Inject constructor(
    private val repository: PropertyDetailRepository
) {
    operator fun invoke(): Flow<ResponseState<PropertyDetail>> = flow {
        try {
            emit(
                ResponseState.Loading()
            )
            val propertyDetail = repository.getPropertyDetail().toDomain()
            emit(
                ResponseState.Success(propertyDetail)
            )

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