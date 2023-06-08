package com.joaquindev.climaapp.presentation.screens

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.climaapp.domain.Resource
import com.joaquindev.climaapp.domain.model.MapResponseDomain
import com.joaquindev.climaapp.domain.use_cases.GetMapWeatherUseCase
import com.joaquindev.climaapp.domain.use_cases.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val getMapWeatherUseCase: GetMapWeatherUseCase
    ) : ViewModel() {
    var state by mutableStateOf(HomeScreenState(isLoading = true))
        private set

    init {
        getMapWeather()
        getWeather()
        Log.d("cahraterssss", state.latitude.toString())
        Log.d("Locations", state.dataLocation?.forEach{
            it.state
        }.toString())
    }


    private fun getWeather() {
        viewModelScope.launch {

            getWeatherUseCase(state.latitude , state.longitude , state.apiKey).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        state = state.copy(
                            climate = result.data !!,
                            isLoading = false,

                            )
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            isLoading = false
                        )

                    }
                    is Resource.Loading -> {
                        state = state.copy(
                            isLoading = true
                        )
                    }
                }
            }.launchIn(this)
        }
    }

    private fun getMapWeather(){
        viewModelScope.launch {

            getMapWeatherUseCase(state.location, state.limit , state.apiKey).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        state = state.copy(
                            dataLocation = ,
                            isLoading = false,

                            )
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            isLoading = false
                        )

                    }
                    is Resource.Loading -> {
                        state = state.copy(
                            isLoading = true
                        )
                    }
                }
            }.launchIn(this)
        }
    }

}

