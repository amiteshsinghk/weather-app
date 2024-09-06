package com.amitesh.weatherapp.data.remote

import com.squareup.moshi.Json

data class WeatherDataDto(
    val time: List<String>,
    @field:Json(name = "temperature_2m")
    val temperatures: List<Double>,
    @field:Json(name = "weathercode")
    val weatherCodes: List<Long>,
    @field:Json(name = "relativehumidity_2m")
    val humidities: List<Long>,
    @field:Json(name = "windspeed_10m")
    val windSpeeds: List<Double>,
    @field:Json(name="pressure_msl")
    val pressures: List<Double>,
)
