package com.joaquindev.climaapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.joaquindev.climaapp.domain.model.MapResponseDomain

import com.joaquindev.climaapp.domain.model.WeatherResponseDomain

@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel){
    val state = homeScreenViewModel.state
    state.climate?.let { Info(climate = it, dataLocation = state.dataLocation) }


}

@Composable
fun Info(climate: WeatherResponseDomain, dataLocation: ArrayList<MapResponseDomain>?){
    Column() {
        Text(text =climate.name )
        Text(text =climate.visibility.toString() )
        Text(text =climate.base )
        Text(text =climate.coord.lat.toString() )
        Text(text =climate.coord.lon.toString() )
        Text(text =climate.main.temp.toString())
        dataLocation?.forEach { location ->
            Text(text = location.lon.toString())
            Text(text = location.lat.toString())
            Text(text = location.state)
            Text(text = location.name)
        }

    }

}