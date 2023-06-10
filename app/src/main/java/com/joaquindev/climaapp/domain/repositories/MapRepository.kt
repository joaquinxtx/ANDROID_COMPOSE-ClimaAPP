package com.joaquindev.climaapp.domain.repositories


import com.joaquindev.climaapp.domain.Resource
import com.joaquindev.climaapp.domain.model.MapResponseDomain

import kotlinx.coroutines.flow.Flow

interface MapRepository {

    suspend fun getMapWeather(
        location: String,
        limit:Int,
        apiKey:String
    ):Flow<Resource<List<MapResponseDomain>>>
}