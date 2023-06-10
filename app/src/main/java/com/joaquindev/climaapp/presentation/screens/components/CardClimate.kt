package com.joaquindev.climaapp.presentation.screens.components

import android.util.Log
import androidx.compose.foundation.layout.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.*


import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joaquindev.climaapp.domain.model.MapResponseDomain
import com.joaquindev.climaapp.domain.model.WeatherResponseDomain
import com.joaquindev.climaapp.presentation.screens.HomeScreenViewModel
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardClimate(
    dataLocation: List<MapResponseDomain>,
    climate: WeatherResponseDomain,
    modifier: Modifier,

    ) {

    Column() {

        Card(
            onClick = { }, modifier = modifier
                .padding(horizontal = 5.dp, vertical = 8.dp)
                .fillMaxWidth()
                .height(250.dp),
            colors = CardDefaults.cardColors(Color(0x6F000000), contentColor = Color.White)
        ) {
            Box(
                modifier = Modifier.fillMaxSize().padding(vertical = 10.dp)
            ) {
                Text(
                    color= Color(0x83FCF6F6),
                    text = climate.sys.country ,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .fillMaxWidth(),
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontWeight = FontWeight.Medium)
                )

                Column(Modifier.align(Alignment.Center)) {
                    val tempInCelsius = climate.main.temp - 273.15
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "${tempInCelsius.roundToInt()}°C",
                        fontSize = 52.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        color= Color(0x83FCF6F6),
                        modifier = Modifier.fillMaxWidth(),
                        text = climate.weather.joinToString { it.description },
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )


                }
                dataLocation.forEach { location ->
                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(8.dp)
                    ) {
                        Text(
                            text = " ${location.name}, ${location.state} ",
                            fontSize = 23.sp
                        )

                        Icon(
                            imageVector = Icons.Outlined.LocationOn,
                            contentDescription = "",
                            modifier = Modifier.align(CenterVertically)
                        )
                    }
                }
            }
        }
        ItemsRow(climate = climate)
    }
}