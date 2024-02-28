package com.example.composemovieapp.presentation.ui.screens.actors.model

import androidx.paging.PagingData
import com.example.composemovieapp.presentation.model.movie.MovieUiModel
import kotlinx.coroutines.flow.StateFlow

interface ActorsUiState {

    data object Loading : ActorsUiState

    data class Error(
        val throwable: Throwable,
        val callbackRetry: ActorsEvent,
    ) : ActorsUiState

    data class Loaded(
        val people: StateFlow<PagingData<MovieUiModel>>,
    ) : ActorsUiState

}