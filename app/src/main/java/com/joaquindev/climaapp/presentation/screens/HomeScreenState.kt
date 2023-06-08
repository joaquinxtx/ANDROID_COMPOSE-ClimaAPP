package com.joaquindev.climaapp.presentation.screens


import com.joaquindev.climaapp.domain.model.MapResponseDomain

import com.joaquindev.climaapp.domain.model.WeatherResponseDomain
import com.joaquindev.climaapp.utils.API_KEY


data class HomeScreenState(
    val climate: WeatherResponseDomain? = null,
    val longitude: Double =10.99,
    val latitude: Double =44.34,
    val apiKey: String = API_KEY,
    val isLoading: Boolean = false,
    val location: String = "london",
    val limit: Int = 1,
    val dataLocation: ArrayList<MapResponseDomain>? = null
)