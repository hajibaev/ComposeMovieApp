package com.example.composemovieapp.presentation.ui.destinations.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composemovieapp.presentation.ui.destinations.MainMovieScreenDestination

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = MainMovieScreenDestination.route
    ) {
        composable(route = MainMovieScreenDestination.route) {
            AppRootScreen()
        }
    }
}