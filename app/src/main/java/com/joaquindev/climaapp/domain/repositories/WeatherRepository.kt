package com.joaquindev.climaapp.domain.repositories


import com.joaquindev.climaapp.domain.Resource
import com.joaquindev.climaapp.domain.model.WeatherResponseDomain
import kotlinx.coroutines.flow.Flow


interface WeatherRepository {
    suspend fun getWeather(
        latitude: Double,
        longitude: Double,
        apiKey: String
    ): Flow<Resource<WeatherResponseDomain>>
}