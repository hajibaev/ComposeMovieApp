package com.example.composemovieapp.presentation.ui.screens.movie_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composemovieapp.domain.base.Mapper
import com.example.composemovieapp.domain.base.Status
import com.example.composemovieapp.domain.model.movie.MovieDetailsDomainModel
import com.example.composemovieapp.domain.model.movie.MovieDomain
import com.example.composemovieapp.domain.use_cases.movie.details.MovieDetailsUseCase
import com.example.composemovieapp.domain.use_cases.movie.recommend.MovieRecommendUseCase
import com.example.composemovieapp.domain.use_cases.movie.similar.MovieSimilarUseCase
import com.example.composemovieapp.presentation.model.movie.MovieDetailsUiModel
import com.example.composemovieapp.presentation.model.movie.MovieUiModel
import com.example.composemovieapp.presentation.ui.screens.movie_details.model.MovieDetailsEvent
import com.example.composemovieapp.presentation.ui.screens.movie_details.model.MovieDetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieDetailsUseCase: MovieDetailsUseCase,
    private val movieRecommendUseCase: MovieRecommendUseCase,
    private val movieSimilarUseCase: MovieSimilarUseCase,
    private val movieDetailsMapper: Mapper<MovieDetailsDomainModel, MovieDetailsUiModel>,
    private val movieMapper: Mapper<MovieDomain, MovieUiModel>
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<MovieDetailsUiState>(MovieDetailsUiState.Loading)
    val uiStateFlow: StateFlow<MovieDetailsUiState> = _uiStateFlow.asStateFlow()

    fun onEvent(event: MovieDetailsEvent) {
        when (event) {
            is MovieDetailsEvent.OnChangeMovieId -> updateMovies(event)
        }
    }

    private fun updateMovies(event: MovieDetailsEvent.OnChangeMovieId) = viewModelScope.launch {
        _uiStateFlow.emit(MovieDetailsUiState.Loading)
        getMovieInfo(event.id, event)
        getSimilarMovies(event.id, event)
        getRecommendationsMovies(event.id, event)
    }

    private suspend fun getMovieInfo(id: Int, event: MovieDetailsEvent) =
        movieDetailsUseCase.invoke(id).also { response ->
            when (response.status) {
                Status.SUCCESS -> response.data?.let {
                    _uiStateFlow.emit(
                        MovieDetailsUiState.Loaded(movieInfo = movieDetailsMapper.map(it))
                    )
                }

                Status.ERROR -> response.errorThrowable?.let { throwable ->
                    _uiStateFlow.emit(MovieDetailsUiState.Error(throwable, event))
                }
            }
        }

    private suspend fun getSimilarMovies(id: Int, event: MovieDetailsEvent) =
        movieSimilarUseCase.invoke(id).also { response ->
            when (response.status) {
                Status.SUCCESS -> response.data?.let {
                    val uiState = _uiStateFlow.value as? MovieDetailsUiState.Loaded ?: return@let
                    _uiStateFlow.emit(uiState.copy(similarMovies = it.map(movieMapper::map)))
                }

                Status.ERROR -> response.errorThrowable?.let { throwable ->
                    _uiStateFlow.emit(MovieDetailsUiState.Error(throwable, event))
                }
            }
        }


    private suspend fun getRecommendationsMovies(id: Int, event: MovieDetailsEvent) =
        movieRecommendUseCase.invoke(id).also { response ->
            when (response.status) {
                Status.SUCCESS -> response.data?.let {
                    val uiState = _uiStateFlow.value as? MovieDetailsUiState.Loaded ?: return@let
                    _uiStateFlow.emit(uiState.copy(recommendationsMovies = it.map(movieMapper::map)))
                }

                Status.ERROR -> response.errorThrowable?.let { throwable ->
                    _uiStateFlow.emit(MovieDetailsUiState.Error(throwable, event))
                }
            }
        }
}