package com.amitesh.weatherapp.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amitesh.weatherapp.domain.repository.LocationTracker
import com.amitesh.weatherapp.domain.repository.WeatherRepository
import com.amitesh.weatherapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker
): ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set


    fun loadWeatherInfo(){
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            Log.d("WeatherApplication","WeatherViewModel")
            locationTracker.getCurrentLocation()?.let {location ->
                Log.d("WeatherApplication","WeatherViewModel :: result.data ${location} ")
                when(val result = repository.getWeatherData(location.latitude,location.longitude)){
                    is Resource.Success ->{
                        Log.d("WeatherApplication","WeatherViewModel :: result.data ${result.data} ")
                        state = state.copy(
                            weatherInfo = result.data,
                            isLoading = false,
                            error = null
                        )
                    }
                    is Resource.Error ->{
                        Log.d("WeatherApplication","WeatherViewModel :: result.data ${result.message} ")
                        state = state.copy(
                            weatherInfo = null,
                            isLoading = false,
                            error = result.message
                        )
                    }

                }
                }?: kotlin.run {
                Log.d("WeatherApplication","WeatherViewModel :: Unknown Error")
                state = state.copy(
                    isLoading = false,
                    error = "Couldn't retrieve location data."
                )

            }
        }
    }
}