package com.joaquindev.climaapp.data.repositories

import com.joaquindev.climaapp.data.source.MapApiService

import com.joaquindev.climaapp.domain.Resource
import com.joaquindev.climaapp.domain.model.MapResponseDomain


import com.joaquindev.climaapp.domain.repositories.MapRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MapRepositoryImpl @Inject constructor(private val apiService: MapApiService) : MapRepository {
    override suspend fun getMapWeather(
        location: String,
        limit: Int,
        apiKey: String
    ): Flow<Resource<MapResponseDomain>> = flow  {
        emit(Resource.Loading())

        try {
            val response = apiService.getCityWeather(location,limit,apiKey)
            val convertedResponse = response.firstOrNull()?.toCountry()
            if (convertedResponse != null){
            emit(Resource.Success(convertedResponse))

            }else{
                emit(Resource.Error(
                    message = "No se encontraron resultados",
                    data = null
                ))
            }

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