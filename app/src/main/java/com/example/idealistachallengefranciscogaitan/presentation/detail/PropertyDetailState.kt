package com.example.idealistachallengefranciscogaitan.presentation.detail

import com.example.idealistachallengefranciscogaitan.domain.model.propertyDetail.PropertyDetail

data class PropertyDetailState(
    val isLoading : Boolean = false,
    val propertyDetail : PropertyDetail? = null,
    val error : String = ""
)
