package com.joaquindev.climaapp.domain.model


import com.joaquindev.climaapp.data.source.dto.mapDto.LocalNames


data class MapResponseDomain(
    val country: String,
    val lat: Double,
    val local_names: LocalNames?,
    val lon: Double,
    val name: String,
    val state: String
)


