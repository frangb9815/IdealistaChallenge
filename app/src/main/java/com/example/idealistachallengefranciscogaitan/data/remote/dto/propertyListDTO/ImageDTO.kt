package com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyListDTO

import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.Image

data class ImageDTO(
    val tag: String,
    val url: String
)

fun ImageDTO.toDomain(): Image {
    return Image(
        tag,
        url
    )
}