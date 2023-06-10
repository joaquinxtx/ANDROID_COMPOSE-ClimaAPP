package com.joaquindev.climaapp.presentation.screens.components

import com.joaquindev.climaapp.R
import com.joaquindev.climaapp.presentation.screens.HomeScreenState

fun iconClimate(state: HomeScreenState?): Int {
    val iconClimate =when (state?.climate?.weather?.joinToString { it.main }) {
        "Clear" -> R.drawable.clearicon
        "Clouds" -> R.drawable.cloudcon
        "Rain" -> R.drawable.rainicon
        "Drizzle" -> R.drawable.drizzleicon
        "Thunderstorm" -> R.drawable.thundericon
        "Snow" -> R.drawable.snowicon
        "Squall" -> R.drawable.rainicon
        "Sunny" -> R.drawable.sunnyicon
        "Windy" -> R.drawable.windyicon
        else -> R.drawable.clearicon
    }
    return iconClimate
}