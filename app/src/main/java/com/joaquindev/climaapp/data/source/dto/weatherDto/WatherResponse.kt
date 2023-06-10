package com.joaquindev.climaapp.data.source.dto.weatherDto

import com.joaquindev.climaapp.domain.model.WeatherResponseDomain

data class WeatherResponse(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)

fun WeatherResponse.toClimate(): WeatherResponseDomain{
    return WeatherResponseDomain(
         base = base,
         clouds= clouds,
         cod= cod,
         coord= coord,
         dt= dt,
         id= id,
         main= main,
         name= name,
         sys= sys,
         timezone= timezone,
         visibility= visibility,
         weather= weather,
         wind= wind


    )
}