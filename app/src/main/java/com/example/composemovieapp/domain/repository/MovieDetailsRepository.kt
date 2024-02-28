package com.example.composemovieapp.domain.repository

import com.example.composemovieapp.domain.base.ResultModel
import com.example.composemovieapp.domain.model.movie.MovieDetailsDomainModel
import com.example.composemovieapp.domain.model.movie.MovieDomain

interface MovieDetailsRepository {

    suspend fun fetchMovieDetails(
        id: Int
    ): ResultModel<MovieDetailsDomainModel>

    suspend fun fetchSimilarMovies(
        id: Int
    ): ResultModel<List<MovieDomain>>

    suspend fun fetchRecommendationsMovies(
        id: Int
    ): ResultModel<List<MovieDomain>>

}