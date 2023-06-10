package com.joaquindev.climaapp.presentation.screens.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.joaquindev.climaapp.R
import com.joaquindev.climaapp.domain.model.WeatherResponseDomain
import kotlin.math.roundToInt

@Composable
fun ItemsRow(climate: WeatherResponseDomain) {
    val tempMinInCelsius = climate.main.temp_min - 273.15
    val tempMaxInCelsius = climate.main.temp_max - 273.15
    Row(Modifier.fillMaxWidth()) {
        ItemClimate(
            tempData = "${tempMinInCelsius.roundToInt()}°C",
            iconTemp = R.drawable.frio,
            title = "Min",
            modifier = Modifier.weight(1f)
        )
        ItemClimate(
            tempData = "${tempMaxInCelsius.roundToInt()}°C",
            iconTemp = R.drawable.altatemperatura,
            title = "Max",
            modifier = Modifier.weight(1f)
        )
        ItemClimate(
            tempData = "${climate.main.humidity} %",
            iconTemp = R.drawable.hum,
            title = "Hum",
            modifier = Modifier.weight(1f)
        )
        ItemClimate(
            tempData = "${climate.wind.speed} ",
            iconTemp = R.drawable.viento,
            title = "viento",
            modifier = Modifier.weight(1f)
        )
    }
}