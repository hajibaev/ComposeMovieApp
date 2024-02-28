package com.example.composemovieapp.presentation.util.interceptors.network_helpers

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.wifi.WifiManager
import android.os.Build
import android.provider.Settings
import javax.inject.Inject

class LiveNetworkMonitor @Inject constructor(
    private val context: Context
) : NetworkMonitor {

    override fun isInternetConnected(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var stateInternetConnected = false
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ->
                        stateInternetConnected = true
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ->
                        stateInternetConnected = true
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) ->
                        stateInternetConnected = true
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected)
                stateInternetConnected = true
        }
        return stateInternetConnected
    }

    override fun isAirplaneMode(): Boolean {
        val isAirplaneModeOn = Settings.Global.getInt(
            context.contentResolver,
            Settings.Global.AIRPLANE_MODE_ON, 0
        ) != 0
        val isWifiEnabled = (context.getSystemService(Context.WIFI_SERVICE) as WifiManager).isWifiEnabled
        return isAirplaneModeOn && !isWifiEnabled
    }

    override fun isNetworkConnectionCommon(): Boolean =
        isInternetConnected() && isAirplaneMode().not()
}