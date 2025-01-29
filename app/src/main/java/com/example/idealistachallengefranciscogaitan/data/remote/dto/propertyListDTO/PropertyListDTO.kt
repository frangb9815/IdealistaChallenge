package com.example.idealistachallengefranciscogaitan.data.remote.dto.propertyListDTO

import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.PropertyListItem

class PropertyListDTO : ArrayList<PropertyListItemDTO>()

fun PropertyListDTO.toDomain(): List<PropertyListItem> {
    return this.map { it.toDomain() }
}