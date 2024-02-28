package com.example.composemovieapp.presentation.ui.screens.home.model

import com.example.composemovieapp.domain.model.movie.MoviePagingType

sealed class MovieEvent {

    data class OnChangeMovieType(
        val movieType: MoviePagingType
    ) : MovieEvent()

    data class OnChangeMovieGenres(
        val genresId: Int
    ) : MovieEvent()

    data object OnGenAllMovieGenres : MovieEvent()
    data class OnLoadNextMovies(val loadNextMovies: Boolean) : MovieEvent()
}
