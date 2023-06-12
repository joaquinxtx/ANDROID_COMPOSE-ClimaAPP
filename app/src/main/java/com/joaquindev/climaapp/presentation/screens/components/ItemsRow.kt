package com.joaquindev.climaapp.presentation.screens.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.joaquindev.climaapp.R
import com.joaquindev.climaapp.domain.model.WeatherResponseDomain

@Composable
fun ItemsRow(climate: WeatherResponseDomain, isLoading: Boolean) {
    val tempMinInCelsius = climate.main.temp_min - 273.15
    val tempMaxInCelsius = climate.main.temp_max - 273.15
    Row(Modifier.fillMaxWidth()) {
        ItemClimate(
            tempData = "${tempMinInCelsius.toInt()}°C",
            iconTemp = R.drawable.frio,
            title = "Min",
            modifier = Modifier.weight(1f), isLoading = isLoading
        )
        ItemClimate(
            tempData = "${tempMaxInCelsius.toInt()}°C",
            iconTemp = R.drawable.altatemperatura,
            title = "Max",
            modifier = Modifier.weight(1f), isLoading = isLoading
        )
        ItemClimate(
            tempData = "${climate.main.humidity} %",
            iconTemp = R.drawable.hum,
            title = "Hum",
            modifier = Modifier.weight(1f), isLoading = isLoading
        )
        ItemClimate(
            tempData = "${climate.wind.speed} k/h ",
            iconTemp = R.drawable.viento,
            title = "Wind",
            modifier = Modifier.weight(1f), isLoading = isLoading
        )
    }
}