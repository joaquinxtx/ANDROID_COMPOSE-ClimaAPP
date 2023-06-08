package com.joaquindev.climaapp.data.source.dto.weatherDto

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)