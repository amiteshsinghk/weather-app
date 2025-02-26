package com.amitesh.weatherapp.presentation

import android.Manifest
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.amitesh.weatherapp.presentation.ui.theme.DarkBlue
import com.amitesh.weatherapp.presentation.ui.theme.DeepBlue
import com.amitesh.weatherapp.presentation.ui.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var  permissionLauncher: ActivityResultLauncher<Array<String>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         permissionLauncher = registerForActivityResult(
             ActivityResultContracts.RequestMultiplePermissions()
         ){
             Log.d("WeatherApp","WeatherViewMode :: inside Result")
             viewModel.loadWeatherInfo()
         }
        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
//        viewModel.loadWeatherInfo()
        setContent {
            WeatherAppTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(DarkBlue)
                ) {
                    WeatherCard(
                        state = viewModel.state,
                        backgroundColor = DeepBlue,
                        modifier = Modifier)
                }
            }
        }
    }
}