package com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyListDTO

import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.Multimedia

data class MultimediaDTO(
    val images: List<ImageDTO>
)

fun MultimediaDTO.toDomain(): Multimedia {
    return Multimedia(
        images.map { it.toDomain() }
    )
}