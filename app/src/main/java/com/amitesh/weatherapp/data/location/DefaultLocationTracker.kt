package com.amitesh.weatherapp.data.location

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.util.Log
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.amitesh.weatherapp.domain.repository.LocationTracker
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
@ExperimentalCoroutinesApi
class DefaultLocationTracker @Inject constructor(
    private val locationClient: FusedLocationProviderClient,
    private val application: Application
) : LocationTracker {
    override suspend fun getCurrentLocation(): Location? {
        Log.d("WeatherApplication","LocationTracker")
        val hasAccessFineLocationPermission = ContextCompat.checkSelfPermission(application,
            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        val hasAccessCoarseLocationPermission = ContextCompat.checkSelfPermission(application,
            Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
        val locationManager = application.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        Log.d("WeatherApplication","LocationTracker :: hasAccessFineLocationPermission $hasAccessFineLocationPermission ::" +
                "hasAccessCoarseLocationPermission $hasAccessCoarseLocationPermission :: isGpsEnabled $isGpsEnabled")
        if (!hasAccessCoarseLocationPermission || !hasAccessFineLocationPermission || !isGpsEnabled){
            return null
        }

        return suspendCancellableCoroutine { cont ->
            locationClient.lastLocation.apply {
                if (isComplete) {
                    Log.d("WeatherApplication","LocationTracker :: isComplete ")
                    if (isSuccessful){
                        Log.d("WeatherApplication","LocationTracker :: isSuccessful")
                    cont.resume(result)
                } else {
                        Log.d("WeatherApplication","LocationTracker :: isComplete :: else")
                    cont.resume(null)
                }
                    Log.d("WeatherApplication","LocationTracker :: isComplete :: return@suspendCancellableCoroutine")
                return@suspendCancellableCoroutine
            }
                addOnSuccessListener {
                    Log.d("WeatherApplication","LocationTracker :: addOnSuccessListener $it")
                    cont.resume(it)
                }
                addOnFailureListener {
                    Log.d("WeatherApplication","LocationTracker :: addOnFailureListener")
                    cont.resume(null)
                }
                addOnCanceledListener {
                    Log.d("WeatherApplication","LocationTracker :: addOnCanceledListener")
                    cont.cancel()
                }
            }

        }
    }
}