package com.example.idealistachallengefranciscogaitan.domain.model.propertyDetail

import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.Image

data class MultimediaDetail(
    val images: List<ImageDetail>
)

fun MultimediaDetail.toImageDomain(): List<Image> {
    return images.map {
        Image(
            url = it.url,
            tag = it.localizedName
        )
    }
}