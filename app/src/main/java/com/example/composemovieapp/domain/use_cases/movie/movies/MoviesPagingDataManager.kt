package com.example.composemovieapp.domain.use_cases.movie.movies

import androidx.paging.PagingData
import com.example.composemovieapp.domain.model.movie.MovieDomain
import com.example.composemovieapp.domain.model.movie.MoviePagingType
import kotlinx.coroutines.flow.Flow

interface MoviesPagingDataManager {

    fun fetchAllMoviesPagingData(
        moviePagingType: MoviePagingType
    ): Flow<PagingData<MovieDomain>>

}