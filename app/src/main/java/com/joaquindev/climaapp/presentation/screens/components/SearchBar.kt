package com.joaquindev.climaapp.presentation.screens.components


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joaquindev.climaapp.domain.model.MapResponseDomain
import com.joaquindev.climaapp.presentation.screens.HomeScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier,
    homeScreenViewModel: HomeScreenViewModel,
    dataLocation: List<MapResponseDomain>
) {
    val newLocation: String by homeScreenViewModel.newLocation.observeAsState(initial = "")
    Box(modifier = modifier) {
        Column() {

            TextField(
                value = newLocation,
                onValueChange = { homeScreenViewModel.onNewLocation(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 0.dp),
                textStyle = TextStyle(fontSize = 16.sp),
                placeholder = { Text(text = "Search", style = TextStyle(fontSize = 16.sp)) },
                maxLines = 1,
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xECE2D6),
                    textColor = Color.White,
                    cursorColor = Color.White,
                    placeholderColor = Color.White
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "",
                        tint = Color.White
                    )
                }

            )

            ButtonNewLocation(
                onClickClimate = {
                    homeScreenViewModel.onClickNewLocation(
                        newLocation,
                        dataLocation
                    )
                }
            )
        }
    }
}