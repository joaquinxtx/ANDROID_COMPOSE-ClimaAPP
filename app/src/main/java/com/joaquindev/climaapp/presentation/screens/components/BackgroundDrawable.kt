package com.joaquindev.climaapp.presentation.screens.components

import com.joaquindev.climaapp.R
import com.joaquindev.climaapp.presentation.screens.HomeScreenState

fun backgroundDrawable(state:HomeScreenState?): Int {
    val backgroundDrawable =when (state?.climate?.weather?.joinToString { it.main }) {
        "Clear" -> R.drawable.clear
        "Clouds" -> R.drawable.clouds
        "Rain" -> R.drawable.rain
        "Drizzle" -> R.drawable.drizle
        "Thunderstorm" -> R.drawable.thunder
        "Snow" -> R.drawable.snow
        "Squall" -> R.drawable.squall
        "Sunny" -> R.drawable.sunny
        "Windy" -> R.drawable.windy
        else -> R.drawable.clear
    }
    return backgroundDrawable
}