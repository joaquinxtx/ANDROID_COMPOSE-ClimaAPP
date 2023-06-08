package com.joaquindev.climaapp.data.repositories

import com.joaquindev.climaapp.data.source.WeatherApiService
import com.joaquindev.climaapp.data.source.dto.weatherDto.toClimate

import com.joaquindev.climaapp.domain.Resource
import com.joaquindev.climaapp.domain.model.WeatherResponseDomain
import com.joaquindev.climaapp.domain.repositories.WeatherRepository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val apiService: WeatherApiService):WeatherRepository {
    override suspend fun getWeather(
        latitude: Double,
        longitude: Double,
        apiKey: String
    ): Flow<Resource<WeatherResponseDomain>> = flow {
        emit(Resource.Loading())

        try {
            val response = apiService.getWeather(latitude,longitude, apiKey).toClimate()
            emit(Resource.Success(response))
        }catch (e: HttpException){
            emit(Resource.Error(
                message = "OOPS ERROR",
                data = null
            ))
        }catch (e: IOException){
            emit(Resource.Error(
                message = "OOPS ERROR server , check connection",
                data = null
            ))
        }

    }
}