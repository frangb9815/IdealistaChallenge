package com.example.idealistachallengefranciscogaitan.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.FavoriteProperty
import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.PropertyListItem
import com.example.idealistachallengefranciscogaitan.domain.usecase.GetFavoritePropertiesUseCase
import com.example.idealistachallengefranciscogaitan.domain.usecase.PropertyListUseCase
import com.example.idealistachallengefranciscogaitan.domain.usecase.SaveFavoritePropertyUseCase
import com.example.idealistachallengefranciscogaitan.utils.ResponseState
import com.example.idealistachallengefranciscogaitan.utils.ResponseState.Companion.UNEXPECTED_ERROR
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertyListViewModel @Inject constructor(
    private val propertyListUseCase: PropertyListUseCase,
    private val getFavoritePropertiesUseCase: GetFavoritePropertiesUseCase,
    private val saveFavoritePropertyUseCase: SaveFavoritePropertyUseCase,

    ) : ViewModel() {

    private val propertyListValue = MutableStateFlow(emptyList<PropertyListItem>())
    var _propertyListValue: StateFlow<List<PropertyListItem>> = propertyListValue

    private val favoriteListValue = MutableStateFlow(emptyList<FavoriteProperty>())
    var _favoriteListValue: StateFlow<List<FavoriteProperty>> = favoriteListValue

    private val loadingState = MutableStateFlow(false)
    var _loadingState: StateFlow<Boolean> = loadingState

    private val errorState = MutableStateFlow("")
    var _errorState: StateFlow<String> = errorState

    fun getAllProperties() = viewModelScope.launch(Dispatchers.IO) {
        propertyListUseCase().collect { response ->
            when (response) {
                is ResponseState.Success -> {
                    propertyListValue.emit(response.data ?: emptyList())
                    loadingState.emit(false)
                }

                is ResponseState.Loading -> {
                    loadingState.emit(true)
                }

                is ResponseState.Error -> {
                    loadingState.emit(false)
                    errorState.emit(response.message ?: UNEXPECTED_ERROR)
                }
            }
        }
    }

    fun getFavoriteProperties() = viewModelScope.launch(Dispatchers.IO) {
        getFavoritePropertiesUseCase().collect { response ->
            when (response) {
                is ResponseState.Success -> {
                    favoriteListValue.emit(response.data ?: emptyList())
                }

                is ResponseState.Loading -> {

                }

                is ResponseState.Error -> {
                    errorState.emit(response.message ?: UNEXPECTED_ERROR)
                }
            }
        }
    }

    fun saveFavoriteProperty(favoriteProperty: FavoriteProperty) =
        viewModelScope.launch(Dispatchers.IO) {
            saveFavoritePropertyUseCase(favoriteProperty).collect { response ->
                when (response) {
                    is ResponseState.Success -> {}

                    is ResponseState.Loading -> {}

                    is ResponseState.Error -> {
                        errorState.emit(response.message ?: UNEXPECTED_ERROR)
                    }
                }
            }
        }
}