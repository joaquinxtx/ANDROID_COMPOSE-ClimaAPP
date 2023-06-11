package com.joaquindev.climaapp.presentation.screens.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joaquindev.climaapp.domain.model.MapResponseDomain
import com.joaquindev.climaapp.domain.model.WeatherResponseDomain
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardClimate(
    dataLocation: List<MapResponseDomain>,
    climate: WeatherResponseDomain,
    modifier: Modifier,
    painter: Painter
) {
    Column() {
        Card(
            onClick = { }, modifier = modifier
                .padding(horizontal = 5.dp, vertical = 8.dp)
                .fillMaxWidth()
                .height(280.dp),
            colors = CardDefaults.cardColors(Color(0xB20F1314), contentColor = Color.White)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 10.dp)
            ) {
                Image(
                    painter = painter,
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(
                            start = 10.dp
                        )
                )
                Text(
                    color = Color(0x83FCF6F6),
                    text = climate.sys.country,
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
                        color = Color(0x83FCF6F6),
                        modifier = Modifier.fillMaxWidth(),
                        text = climate.weather.joinToString { it.description },
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )
                }
                dataLocation.forEach { location ->
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(8.dp)
                    ) {
                        Row() {
                            Text(

                                text = location.name,
                                fontSize = 23.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(end = 5.dp)
                            )
                            Icon(
                                imageVector = Icons.Outlined.LocationOn,
                                contentDescription = "",
                                modifier = Modifier.align(CenterVertically)
                            )
                        }
                        Text(
                            text = location.state,
                            fontSize = 15.sp,
                            color = Color(0x83FCF6F6),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}