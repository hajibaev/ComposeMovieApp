package com.example.composemovieapp.presentation.util.interceptors.network_helpers

interface NetworkMonitor {
    fun isInternetConnected(): Boolean
    fun isAirplaneMode(): Boolean
    fun isNetworkConnectionCommon(): Boolean
}