package com.joaquindev.climaapp.presentation.screens


import com.joaquindev.climaapp.domain.model.MapResponseDomain
import com.joaquindev.climaapp.domain.model.WeatherResponseDomain

import com.joaquindev.climaapp.utils.API_KEY


data class HomeScreenState(
    val climate: WeatherResponseDomain? = null,
    val apiKey: String = API_KEY,
    val isLoading: Boolean = false,
    var longitude: Double = -64.18,
    var latitude: Double = -31.41,
    val dataLocation: List<MapResponseDomain> = emptyList(),
    var location: String = "Cordoba",
    val limit: Int = 1,
)