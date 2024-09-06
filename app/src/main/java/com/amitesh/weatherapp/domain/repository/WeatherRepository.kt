package com.amitesh.weatherapp.domain.repository

import com.amitesh.weatherapp.domain.util.Resource
import com.amitesh.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}