package com.example.composemovieapp.data.cloud.data_source.movie

import com.example.composemovieapp.data.model.movie.MovieGenresResponseData
import com.example.composemovieapp.data.model.movie.MoviesResponseData
import com.example.composemovieapp.domain.base.ResultModel

interface MovieDataSource {

    suspend fun fetchAllTrending(
        page: Int,
    ): ResultModel<MoviesResponseData>

    suspend fun fetchAllPopular(
        page: Int,
    ): ResultModel<MoviesResponseData>

    suspend fun fetchAllNowPlaying(
        page: Int,
    ): ResultModel<MoviesResponseData>

    suspend fun fetchAllUpcoming(
        page: Int,
    ): ResultModel<MoviesResponseData>

    suspend fun fetchAllTopRated(
        page: Int,
    ): ResultModel<MoviesResponseData>

    suspend fun fetchAllGenres(): ResultModel<MovieGenresResponseData>

}