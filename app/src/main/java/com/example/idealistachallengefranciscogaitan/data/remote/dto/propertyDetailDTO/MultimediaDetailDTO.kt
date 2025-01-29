package com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyDetailDTO

import com.example.idealistachallengefranciscogaitan.domain.model.propertyDetail.MultimediaDetail

data class MultimediaDetailDTO(
    val images: List<ImageDetailDTO>
)

fun MultimediaDetailDTO.toDomain(): MultimediaDetail {
    return MultimediaDetail(
        images.map { it.toDomain() }
    )
}