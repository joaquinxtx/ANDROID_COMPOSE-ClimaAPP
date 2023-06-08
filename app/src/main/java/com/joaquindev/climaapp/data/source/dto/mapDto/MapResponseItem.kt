package com.joaquindev.climaapp.data.source.dto.mapDto

import com.joaquindev.climaapp.domain.model.MapResponseDomain


data class MapResponseItem(
    val country: String,
    val lat: Double,
    val local_names: LocalNames,
    val lon: Double,
    val name: String,
    val state: String
){
    fun toCountry(): MapResponseDomain {
        return MapResponseDomain(
            country= country,
            lat= lat,
            local_names= local_names,
            lon=lon,
            name= name,
            state= state

        )
    }
}

