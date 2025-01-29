package com.example.idealistachallengefranciscogaitan.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.idealistachallengefranciscogaitan.domain.usecase.PropertyDetailUseCase
import com.example.idealistachallengefranciscogaitan.domain.usecase.PropertyListUseCase
import com.example.idealistachallengefranciscogaitan.utils.ResponseState
import com.example.idealistachallengefranciscogaitan.utils.ResponseState.Companion.UNEXPECTED_ERROR
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertyDetailViewModel @Inject constructor(
    private val propertyDetailUseCase: PropertyDetailUseCase
) : ViewModel() {

    private val propertyDetailValue = MutableStateFlow(PropertyDetailState())
    var _propertyDetailValue: StateFlow<PropertyDetailState> = propertyDetailValue

    fun getPropertyDetail() = viewModelScope.launch(Dispatchers.IO) {
        propertyDetailUseCase().collect {
            when (it) {
                is ResponseState.Success -> {
                    propertyDetailValue.value =
                        PropertyDetailState(propertyDetail = it.data)
                }

                is ResponseState.Loading -> {
                    propertyDetailValue.value = PropertyDetailState(isLoading = true)
                }

                is ResponseState.Error -> {
                    propertyDetailValue.value =
                        PropertyDetailState(error = it.message ?: UNEXPECTED_ERROR)
                }
            }
        }
    }
}