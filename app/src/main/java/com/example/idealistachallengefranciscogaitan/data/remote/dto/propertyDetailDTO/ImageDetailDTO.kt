package com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyDetailDTO

import com.example.idealistachallengefranciscogaitan.domain.model.propertyDetail.ImageDetail

data class ImageDetailDTO(
    val localizedName: String,
    val multimediaId: Int,
    val tag: String,
    val url: String
)

fun ImageDetailDTO.toDomain(): ImageDetail {
    return ImageDetail(
        localizedName,
        multimediaId,
        tag,
        url
    )
}