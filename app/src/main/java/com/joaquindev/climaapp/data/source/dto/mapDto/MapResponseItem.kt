package com.joaquindev.climaapp.data.source.dto.mapDto

data class MapResponseItem(
    val country: String,
    val lat: Double,
    val local_names: LocalNames,
    val lon: Double,
    val name: String,
    val state: String
)

