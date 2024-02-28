package com.example.composemovieapp.presentation.ui.screens.movie_details

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.composemovieapp.presentation.model.movie.MovieUiModel
import com.example.composemovieapp.presentation.ui.components.items.MovieDetailsItem
import com.example.composemovieapp.presentation.ui.core.colors.MovieTheme
import com.example.composemovieapp.presentation.ui.core.ui_components.LoadingScreen
import com.example.composemovieapp.presentation.ui.core.ui_components.ShowError
import com.example.composemovieapp.presentation.ui.screens.movie_details.model.MovieDetailsEvent
import com.example.composemovieapp.presentation.ui.screens.movie_details.model.MovieDetailsUiState
import com.example.composemovieapp.presentation.util.constains.MotionConstants.ScreenDuration
import com.example.composemovieapp.presentation.util.fonts.dp180
import com.example.composemovieapp.presentation.util.fonts.dp290
import com.example.composemovieapp.presentation.util.fonts.dp6
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@Composable
fun MovieDetailsScreen(
    id: Int,
    uiState: StateFlow<MovieDetailsUiState>,
    onEvent: (MovieDetailsEvent) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        coroutineScope.launch {
            delay(ScreenDuration.toLong())
            onEvent(MovieDetailsEvent.OnChangeMovieId(id))
        }
    }

    when (val state = uiState.collectAsState().value) {
        is MovieDetailsUiState.Loading -> LoadingScreen()
        is MovieDetailsUiState.Error -> ShowError(
            throwable = state.throwable,
            onConfirmation = { onEvent(state.callbackRetry) }
        )

        is MovieDetailsUiState.Loaded -> LoadedMovieDetailsScreen(
            uiState = state,
            onChangeMovieId = {
                onEvent(MovieDetailsEvent.OnChangeMovieId(it))
            }
        )
    }
}

@Composable
fun LoadedMovieDetailsScreen(
    uiState: MovieDetailsUiState.Loaded,
    onChangeMovieId: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Log.i("Umar", "backdropPath = ${uiState.movieInfo.backdropPath}")

        Text(
            text = "Movie Title = ${uiState.movieInfo.title}",
            style = MovieTheme.typography.titleLarge,
            color = MovieTheme.colors.colorOnSurface,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Similar Movies",
            style = MovieTheme.typography.titleLarge,
            color = MovieTheme.colors.colorOnSurface,
            fontWeight = FontWeight.Bold,
        )
        SimilarMoviesList(
            similarMovies = uiState.similarMovies,
            onChangeMovieId = onChangeMovieId
        )
        Text(
            text = "Recommendations Movies",
            style = MovieTheme.typography.titleLarge,
            color = MovieTheme.colors.colorOnSurface,
            fontWeight = FontWeight.Bold,
        )
        RecommendationsMoviesList(
            recommendations = uiState.recommendationsMovies,
            onChangeMovieId = onChangeMovieId
        )
    }
}

@Composable
fun SimilarMoviesList(
    similarMovies: List<MovieUiModel>,
    onChangeMovieId: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    LazyRow(
        modifier = modifier.padding(dp6)
    ) {
        items(
            items = similarMovies,
            key = { movie -> movie.hashCode() }
        ) { movie ->
            MovieDetailsItem(
                id = movie.movieId,
                poster = movie.poster,
                popularity = movie.popularity,
                onClick = onChangeMovieId,
                modifier = Modifier
                    .width(dp180)
                    .height(dp290)
            )
        }
    }
}

@Composable
fun RecommendationsMoviesList(
    recommendations: List<MovieUiModel>,
    onChangeMovieId: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.padding(dp6)
    ) {
        items(
            items = recommendations,
            key = { movie -> movie.hashCode() }
        ) { movie ->
            MovieDetailsItem(
                id = movie.movieId,
                poster = movie.poster,
                popularity = movie.popularity,
                onClick = onChangeMovieId,
                modifier = Modifier
                    .width(dp180)
                    .height(dp290)
            )
        }
    }
}