package com.joaquindev.climaapp.domain.use_cases



import com.joaquindev.climaapp.domain.Resource
import com.joaquindev.climaapp.domain.model.WeatherResponseDomain
import com.joaquindev.climaapp.domain.repositories.WeatherRepository
import kotlinx.coroutines.flow.Flow


import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(private val repository: WeatherRepository) {
    suspend operator fun invoke(latitude: Double, longitude: Double ,apiKey:String): Flow<Resource<WeatherResponseDomain>> {
        return repository.getWeather(latitude,longitude, apiKey )
    }
}