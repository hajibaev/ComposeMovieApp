package com.example.composemovieapp.presentation.ui.destinations.nav_graph

import BottomNavigationDestinations
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.composemovieapp.data.util.MovieDataConstants.EMPTY_ID
import com.example.composemovieapp.presentation.ui.destinations.MovieDetailsScreenDestination
import com.example.composemovieapp.presentation.ui.screens.actors.ActorsScreen
import com.example.composemovieapp.presentation.ui.screens.actors.ActorsViewModel
import com.example.composemovieapp.presentation.ui.screens.home.HomeViewModel
import com.example.composemovieapp.presentation.ui.screens.home.MainScreen
import com.example.composemovieapp.presentation.ui.screens.movie_details.MovieDetailsScreen
import com.example.composemovieapp.presentation.ui.screens.movie_details.MovieDetailsViewModel
import com.example.composemovieapp.presentation.util.animation.translateYIn
import com.example.composemovieapp.presentation.util.animation.translateYOut

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BottomNavigationDestinations.Main.route
    ) {
        composable(route = BottomNavigationDestinations.Main.route) {
            val viewModel: HomeViewModel = hiltViewModel()
            MainScreen(
                uiState = viewModel::uiState.get(),
                onEvent = viewModel::onEvent,
                navigateToDetailsScreen = { id ->
                    navController.navigate("${MovieDetailsScreenDestination.route}/$id")
                }
            )
        }

        composable(route = BottomNavigationDestinations.Actors.route) {
            val viewModel: ActorsViewModel = hiltViewModel()
            ActorsScreen(
                peoples = viewModel::peoples.get().collectAsLazyPagingItems()
            )
        }

        composable(
            route = MovieDetailsScreenDestination.routeWithArgs,
            arguments = MovieDetailsScreenDestination.arguments,
            enterTransition = { translateYIn { it } },
            exitTransition = { translateYOut { it } },
        ) { navBackStackEntry ->
            val viewModel: MovieDetailsViewModel = hiltViewModel()
            val movieId =
                navBackStackEntry.arguments?.getInt(MovieDetailsScreenDestination.id) ?: EMPTY_ID

            MovieDetailsScreen(
                id = movieId,
                uiState = viewModel.uiStateFlow,
                onEvent = viewModel::onEvent
            )
        }
    }
}