package com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyDetailDTO

import com.example.idealistachallengefranciscogaitan.domain.model.propertyDetail.EmissionsDetail

data class EmissionsDetailDTO(
    val type: String
)

fun EmissionsDetailDTO.toDomain(): EmissionsDetail {
    return EmissionsDetail(
        type
    )
}