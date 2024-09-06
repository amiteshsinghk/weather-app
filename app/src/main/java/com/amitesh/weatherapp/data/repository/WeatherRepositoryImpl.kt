package com.amitesh.weatherapp.data.repository

import android.util.Log
import com.amitesh.weatherapp.data.mapper.toWeatherInfo
import com.amitesh.weatherapp.data.remote.WeatherApi
import com.amitesh.weatherapp.domain.repository.WeatherRepository
import com.amitesh.weatherapp.domain.util.Resource
import com.amitesh.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Log.d("WeatherApplication","WeatherRepositoryImpl :: getWeatherData ")
           Resource.Success(
               data = api.getWeatherData(lat = lat, long = long).toWeatherInfo()
           )
        } catch (e: Exception){
            Log.d("WeatherApplication","WeatherRepositoryImpl :: Exception  $e")
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}