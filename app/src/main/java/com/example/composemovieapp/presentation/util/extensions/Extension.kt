package com.example.composemovieapp.presentation.util.extensions

import android.annotation.SuppressLint
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import com.example.composemovieapp.R
import com.example.composemovieapp.data.util.MovieDataConstants.EMPTY_STRING
import com.example.composemovieapp.data.util.MovieDataConstants.NOT_FOUND
import com.example.composemovieapp.domain.model.movie.MoviePagingType
import com.example.composemovieapp.presentation.util.interceptors.ConnectionNetworkException
import com.example.composemovieapp.presentation.util.interceptors.FlightModeException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

val LocalDarkTheme = compositionLocalOf { mutableStateOf(false) }

fun isNetworkError(error: Throwable): Boolean = when (error) {
    is UnknownHostException, is SocketTimeoutException, is ConnectionNetworkException, is FlightModeException -> true
    else -> false
}

@SuppressLint("NewApi")
fun formatReleaseDate(inputDate: String): String {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val outputFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.getDefault())

    val date = if (inputDate == EMPTY_STRING) return NOT_FOUND
    else LocalDate.parse(inputDate, inputFormatter)

    return outputFormatter.format(date)
}

fun MoviePagingType.toTitle(): Int {
    return when (this) {
        MoviePagingType.TOP_RATED -> R.string.movie_top_rated
        MoviePagingType.UPCOMING -> R.string.movie_up_coming
        MoviePagingType.NOW_PLAYING -> R.string.movie_now_playing
        MoviePagingType.POPULAR -> R.string.movie_popular
        MoviePagingType.TRENDING -> R.string.movie_trending
    }
}
