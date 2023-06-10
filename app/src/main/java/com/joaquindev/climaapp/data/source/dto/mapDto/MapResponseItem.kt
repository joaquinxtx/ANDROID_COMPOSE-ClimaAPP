package com.joaquindev.climaapp.data.source.dto.mapDto

import com.joaquindev.climaapp.domain.model.MapResponseDomain


data class MapResponseItem(
    val country: String,
    val lat: Double,
    val local_names: LocalNames,
    val lon: Double,
    val name: String,
    val state: String
)

