package com.example.composemovieapp.data.cloud.data_source.movie_details

import com.example.composemovieapp.data.model.movie.MovieDetailsDataModel
import com.example.composemovieapp.data.model.movie.MoviesResponseData
import com.example.composemovieapp.domain.base.ResultModel

interface MovieDetailsDataSource {

    suspend fun fetchMovieDetails(
        id: Int
    ): ResultModel<MovieDetailsDataModel>

    suspend fun fetchSimilarMovies(
        id: Int
    ): ResultModel<MoviesResponseData>

    suspend fun fetchRecommendationsMovies(
        id: Int
    ): ResultModel<MoviesResponseData>


}