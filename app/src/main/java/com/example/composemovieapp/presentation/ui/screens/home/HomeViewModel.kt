package com.example.composemovieapp.presentation.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.filter
import androidx.paging.map
import com.example.composemovieapp.data.cloud.data_source.movie.MovieDataSource
import com.example.composemovieapp.data.model.movie.MovieData
import com.example.composemovieapp.data.util.MovieDataConstants.EMPTY_ID
import com.example.composemovieapp.domain.base.Mapper
import com.example.composemovieapp.domain.model.movie.MovieDomain
import com.example.composemovieapp.domain.model.movie.MovieGenresDomain
import com.example.composemovieapp.domain.model.movie.MoviePagingType
import com.example.composemovieapp.domain.use_cases.movie.genres.MovieGenresUseCase
import com.example.composemovieapp.domain.use_cases.movie.movies.MoviesPagingDataManager
import com.example.composemovieapp.presentation.model.movie.MovieGenresUiModel
import com.example.composemovieapp.presentation.model.movie.MovieUiModel
import com.example.composemovieapp.presentation.ui.screens.home.model.MovieEvent
import com.example.composemovieapp.presentation.ui.screens.home.model.MovieUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    moviesPagingDataManager: MoviesPagingDataManager,
    private val movieGenresUseCase: MovieGenresUseCase,
    private val movieMapper: Mapper<MovieDomain, MovieUiModel>,
    private val movieGenresMapper: Mapper<MovieGenresDomain, MovieGenresUiModel>,
    private val moviesPagingDataSource: MovieDataSource,
    private val dataToDomain: Mapper<MovieData, MovieDomain>,
) : ViewModel() {

    private var currentPage = 1

    private val _uiState = MutableStateFlow<MovieUiState>(MovieUiState.Loading)
    val uiState = _uiState.asStateFlow()

    private val movieType = MutableSharedFlow<MoviePagingType>()
    private val genresId = MutableStateFlow(EMPTY_ID)

    private val movieFilterByCategory = movieType.combine(genresId) { movieType, genresId ->
        Pair(movieType, genresId)
    }

    private val moviesFlow = movieFilterByCategory.flatMapLatest { movie ->
        moviesPagingDataManager.fetchAllMoviesPagingData(movie.first).let { data ->
            if (movie.second == EMPTY_ID) data
            else data.map { paging -> paging.filter { it.genreIds.contains(movie.second) } }
        }
    }.map { pagingData -> pagingData.map(movieMapper::map) }
        .cachedIn(viewModelScope)

    init {
        viewModelScope.launch {
//            moviesFlow.collect {
//                val uiState = _uiState.value as? MovieUiState.Loaded ?: return@collect
//                _uiState.emit(uiState.copy(movies = MutableStateFlow(it)))
//            }
        }
        loadMovies(false)
    }

    fun onEvent(event: MovieEvent) {
        when (event) {
            is MovieEvent.OnChangeMovieType -> setMovieType(event)
            is MovieEvent.OnGenAllMovieGenres -> getMovieGenres(event)
            is MovieEvent.OnChangeMovieGenres -> changeMovieGenres(event)
            is MovieEvent.OnLoadNextMovies -> loadMovies(event.loadNextMovies)
        }
    }

    private fun setMovieType(event: MovieEvent.OnChangeMovieType) = viewModelScope.launch {
//        movieType.emit(event.movieType)
//        val uiState = _uiState.value as? MovieUiState.Loaded ?: return@launch
//        _uiState.update { (uiState.copy(selectedMovieType = event.movieType)) }
    }

    private fun changeMovieGenres(event: MovieEvent.OnChangeMovieGenres) = viewModelScope.launch {
//        genresId.emit(event.genresId)
//        val uiState = _uiState.value as? MovieUiState.Loaded ?: return@launch
//        _uiState.update {
//            (uiState.copy(selectedGenresId = event.genresId))
//        }
    }

    private fun getMovieGenres(event: MovieEvent.OnGenAllMovieGenres) = viewModelScope.launch {
//        movieGenresUseCase.invoke().also { response ->
//            when (response.status) {
//                Status.SUCCESS -> response.data?.let { genres ->
//                    _uiState.update {
//                        MovieUiState.Loaded(genres = genres.map { movieGenresMapper.map(it) })
//                    }
//                    onEvent(MovieEvent.OnChangeMovieType(MoviePagingType.TRENDING))
//                }
//
//                Status.ERROR -> response.errorThrowable?.let { throwable ->
//                    _uiState.emit(MovieUiState.Error(throwable, event))
//                }
//            }
//        }
    }

    private fun loadMovies(forceReload: Boolean = false) = viewModelScope.launch {
        _uiState.emit(MovieUiState.MoviePaging(loading = true))
        val uiState = _uiState.value as? MovieUiState.MoviePaging ?: return@launch
        if (forceReload) currentPage = 1
        if (currentPage == 1) _uiState.emit(uiState.copy(refreshing = true))

        val resultMovies =
            moviesPagingDataSource.fetchAllTrending(page = currentPage)
                .data?.movies?.map { dataToDomain.map(it) }
                ?.map { movieMapper.map(it) } ?: emptyList()
        Log.i("Umar", "uiState.movies size = ${uiState.movies.size}")

        val movies = if (currentPage == 1) resultMovies else uiState.movies + resultMovies
        currentPage += 1
        Log.i("Umar", "movies = ${movies.size}")
        _uiState.emit(
            uiState.copy(
                loading = false,
                refreshing = false,
                loadFinished = resultMovies.isEmpty(),
                movies = movies
            )
        )
        Log.i("Umar", "resultMovies size = ${resultMovies.size}")

    }

}

