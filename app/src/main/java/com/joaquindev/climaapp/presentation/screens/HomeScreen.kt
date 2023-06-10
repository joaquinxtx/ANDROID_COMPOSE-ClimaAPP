package com.joaquindev.climaapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*

import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.joaquindev.climaapp.R

import com.joaquindev.climaapp.domain.model.MapResponseDomain

import com.joaquindev.climaapp.domain.model.WeatherResponseDomain
import com.joaquindev.climaapp.presentation.screens.components.ButtonNewLocation
import com.joaquindev.climaapp.presentation.screens.components.CardClimate
import com.joaquindev.climaapp.presentation.screens.components.SearchBar

@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel) {
    val newLocation: String by homeScreenViewModel.newLocation.observeAsState(initial = "")
    val state by homeScreenViewModel.state.observeAsState()
    val backgroundDrawable = when (state?.climate?.weather?.joinToString { it.main }) {
        "Clear" -> R.drawable.clear
        "Clouds" -> R.drawable.clouds
        "Rain" -> R.drawable.rain
        "Drizzle" -> R.drawable.drizle
        "Thunderstorm" -> R.drawable.thunder
        "Snow" -> R.drawable.snow
        "Squall" -> R.drawable.squall
        "Sunny" -> R.drawable.sunny
        "Windy" -> R.drawable.windy
        else -> R.drawable.fondo
    }
    Box(
        modifier = Modifier.fillMaxSize(),

        ) {

            Image(
                painter = painterResource(backgroundDrawable),
                contentDescription = "-",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                    setToScale(
                        0.8f,
                        0.8f,
                        0.8f,
                        1f
                    )

                })
            )
        if (state?.isLoading == false){
            Column() {
                state?.dataLocation?.let { SearchBar(modifier = Modifier, homeScreenViewModel = homeScreenViewModel, dataLocation = it) }

                state?.climate?.let {
                    state?.dataLocation?.let { it1 ->
                        CardClimate(
                            climate = it,
                            dataLocation = it1,
                            modifier = Modifier,

                            )
                    }
                }


            }
        }
        }


}


