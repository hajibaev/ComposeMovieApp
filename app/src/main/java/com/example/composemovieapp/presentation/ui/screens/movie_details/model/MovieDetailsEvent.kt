package com.example.composemovieapp.presentation.ui.screens.movie_details.model

sealed interface MovieDetailsEvent {

    data class OnChangeMovieId(
        val id: Int,
    ) : MovieDetailsEvent

}