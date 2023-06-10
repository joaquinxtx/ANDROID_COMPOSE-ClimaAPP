package com.joaquindev.climaapp.presentation.screens


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
    private val _state = MutableLiveData(HomeScreenState(isLoading = true))
    val state: LiveData<HomeScreenState> = _state

    private val _newLocation = MutableLiveData<String>()
    val newLocation: LiveData<String> = _newLocation



    fun onNewLocation(newLocation: String) {
        _newLocation.value = newLocation
    }

    fun onClickNewLocation(newLocation: String, dataLocation: List<MapResponseDomain>) =
        viewModelScope.launch {
            state.value?.location = newLocation
            getMapWeather()
            _newLocation.value = ""
        }
    init {
        getMapWeather()
    }
    private fun getWeather(longitude:Double , latitude:Double) {
        viewModelScope.launch {
            state.value?.let {
                getWeatherUseCase(latitude,longitude, it.apiKey).onEach { result ->
                    when (result) {
                        is Resource.Success -> {
                            _state.value = state.value?.copy(
                                climate = result.data!!,
                                isLoading = false,
                                )
                        }
                        is Resource.Error -> {
                            _state.value = state.value?.copy(
                                isLoading = false
                            )
                        }
                        is Resource.Loading -> {
                            _state.value = state.value?.copy(
                                isLoading = true
                            )
                        }
                    }
                }.launchIn(this)
            }
        }
    }
    private fun getMapWeather() {
        viewModelScope.launch {
            state.value?.let {
                getMapWeatherUseCase(it.location, it.limit, it.apiKey).onEach { result ->
                    when (result) {
                        is Resource.Success -> {
                            val dataLocation = result.data ?: emptyList()
                            _state.value = state.value?.copy(
                                dataLocation = dataLocation,
                                isLoading = false,
                            )
                            if (dataLocation.isNotEmpty()){
                                val location = dataLocation[0]
                                val latitude = location.lat
                                val longitude= location.lon
                                getWeather(longitude,latitude)
                            }
                        }
                        is Resource.Error -> {
                            _state.value = state.value?.copy(
                                isLoading = false
                            )
                        }
                        is Resource.Loading -> {
                            _state.value = state.value?.copy(
                                isLoading = true
                            )
                        }
                    }
                }.launchIn(this)
            }
        }
    }

}

