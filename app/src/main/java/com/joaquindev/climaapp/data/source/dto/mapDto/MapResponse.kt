package com.joaquindev.climaapp.data.source.dto.mapDto

import com.joaquindev.climaapp.domain.model.MapResponseDomain

class MapResponse : ArrayList<MapResponseItem>()

fun MapResponse.toMapResponseDomain(): List<MapResponseDomain> {
    return this.map { mapResponseItem ->
        MapResponseDomain(
            country = mapResponseItem.country,
            lat = mapResponseItem.lat,
            local_names = mapResponseItem.local_names,
            lon = mapResponseItem.lon,
            name = mapResponseItem.name,
            state = mapResponseItem.state
        )
    }
}