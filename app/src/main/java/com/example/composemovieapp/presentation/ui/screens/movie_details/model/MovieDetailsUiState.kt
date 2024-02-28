package com.example.composemovieapp.presentation.ui.screens.movie_details.model

import androidx.compose.runtime.Immutable
import com.example.composemovieapp.presentation.model.movie.MovieDetailsUiModel
import com.example.composemovieapp.presentation.model.movie.MovieUiModel

@Immutable
sealed interface MovieDetailsUiState {

    data object Loading : MovieDetailsUiState

    data class Error(
        val throwable: Throwable,
        val callbackRetry: MovieDetailsEvent,
    ) : MovieDetailsUiState

    data class Loaded(
        val movieInfo: MovieDetailsUiModel,
        val similarMovies: List<MovieUiModel> = emptyList(),
        val recommendationsMovies: List<MovieUiModel> = emptyList(),
        val isSaved: Boolean = false
    ) : MovieDetailsUiState

}