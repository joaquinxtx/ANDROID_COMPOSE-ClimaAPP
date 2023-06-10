package com.joaquindev.climaapp.data.source

import com.joaquindev.climaapp.data.source.dto.mapDto.MapResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MapApiService {
    @GET("geo/1.0/direct")
    suspend fun getCityWeather(
        @Query("q") location: String,
        @Query("limit") limit: Int,
        @Query("appid") apiKey: String
    ):MapResponse
}