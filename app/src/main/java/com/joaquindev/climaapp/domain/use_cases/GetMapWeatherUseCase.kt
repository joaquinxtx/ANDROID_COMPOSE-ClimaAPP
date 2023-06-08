package com.joaquindev.climaapp.domain.use_cases

import com.joaquindev.climaapp.domain.Resource
import com.joaquindev.climaapp.domain.model.MapResponseDomain

import com.joaquindev.climaapp.domain.repositories.MapRepository

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMapWeatherUseCase @Inject constructor(private val repository: MapRepository) {
    suspend operator fun invoke(location:String,limit:Int,apiKey:String): Flow<Resource<MapResponseDomain>> {
        return repository.getMapWeather(location,limit,apiKey)
    }
}