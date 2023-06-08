package com.joaquindev.climaapp.core

import com.joaquindev.climaapp.data.repositories.MapRepositoryImpl
import com.joaquindev.climaapp.data.repositories.WeatherRepositoryImpl
import com.joaquindev.climaapp.domain.repositories.MapRepository
import com.joaquindev.climaapp.domain.repositories.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoriesModule {
    @Binds
    abstract fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository

    @Binds
    abstract fun bindMapRepository(impl: MapRepositoryImpl): MapRepository
}