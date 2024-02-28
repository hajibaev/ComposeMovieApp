package com.example.composemovieapp.presentation.ui.destinations

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Destination {
    val route: String
}

object MainMovieScreenDestination : Destination {
    override val route: String = "movie"
}

object MovieDetailsScreenDestination : Destination {
    const val id = "movieId"
    override val route: String = "detail_screen"
    val routeWithArgs = "$route/{$id}"
    val arguments = listOf(navArgument(id) { type = NavType.IntType })
}