package com.example.composemovieapp.presentation.ui.screens.home.model

import androidx.paging.PagingData
import com.example.composemovieapp.data.util.MovieDataConstants.EMPTY_ID
import com.example.composemovieapp.domain.model.movie.MoviePagingType
import com.example.composemovieapp.presentation.model.movie.MovieGenresUiModel
import com.example.composemovieapp.presentation.model.movie.MovieUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

sealed class MovieUiState {

    data object Loading : MovieUiState()

    data class Error(
        val throwable: Throwable,
        val callbackRetry: MovieEvent,
    ) : MovieUiState()


    data class Loaded(
        val genres: List<MovieGenresUiModel>,
        val movies: StateFlow<PagingData<MovieUiModel>> = MutableStateFlow(PagingData.empty()),
        val selectedMovieType: MoviePagingType = MoviePagingType.TRENDING,
        val selectedGenresId: Int = EMPTY_ID
    ) : MovieUiState()

    data class MoviePaging(
        val loading: Boolean,
        val refreshing: Boolean = false,
        val movies: List<MovieUiModel> = listOf(),
        val loadFinished: Boolean = false
    ):MovieUiState()

}
