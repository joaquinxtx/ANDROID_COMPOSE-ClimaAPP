package com.joaquindev.climaapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import com.joaquindev.climaapp.presentation.screens.components.*

@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel) {
    val state by homeScreenViewModel.state.observeAsState()
    Box(
        modifier = Modifier.fillMaxSize(),
        ) {
        Image(
            painter = painterResource(backgroundDrawable(state)),
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
        Column() {
            state?.dataLocation?.let {
                SearchBar(
                    modifier = Modifier,
                    homeScreenViewModel = homeScreenViewModel,
                    dataLocation = it
                )
            }
            state?.let {
                Loader(isLoading = it.isLoading) {
                    it.climate?.let { climate ->
                        CardClimate(
                            dataLocation = it.dataLocation,
                            climate = climate,
                            modifier = Modifier,
                            painter = painterResource(id = iconClimate(state))
                        )
                    }
                }
            }
            state?.let {
                LoaderItem(isLoading = it.isLoading) {
                    state?.climate?.let { climate ->
                        ItemsRow(
                            climate = climate,
                            isLoading = it.isLoading
                        )
                    }
                }
            }
        }
    }
}






