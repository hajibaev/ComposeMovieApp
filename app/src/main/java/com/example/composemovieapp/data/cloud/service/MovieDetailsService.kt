package com.example.composemovieapp.data.cloud.service

import com.example.composemovieapp.data.model.movie.MovieDetailsDataModel
import com.example.composemovieapp.data.model.movie.MoviesResponseData
import com.example.composemovieapp.data.util.MovieDataConstants.APIKEY
import com.example.composemovieapp.data.util.MovieDataConstants.LANGUAGE
import com.example.composemovieapp.data.util.MovieDataConstants.MOVIE_DETAILS
import com.example.composemovieapp.data.util.MovieDataConstants.MOVIE_ID
import com.example.composemovieapp.data.util.MovieDataConstants.RECOMMENDATIONS
import com.example.composemovieapp.data.util.MovieDataConstants.SIMILAR
import com.example.composemovieapp.di.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailsService {

    @GET(MOVIE_DETAILS)
    suspend fun fetchMovieDetails(
        @Path(MOVIE_ID) id: Int,
        @Query(APIKEY) apiKey: String = API_KEY,
        @Query(LANGUAGE) language: String,
    ): Response<MovieDetailsDataModel>

    @GET(SIMILAR)
    suspend fun fetchSimilarMovies(
        @Path(MOVIE_ID) id: Int,
        @Query(APIKEY) apiKey: String = API_KEY,
        @Query(LANGUAGE) language: String,
    ): Response<MoviesResponseData>

    @GET(RECOMMENDATIONS)
    suspend fun fetchRecommendationsMovies(
        @Path(MOVIE_ID) id: Int,
        @Query(APIKEY) apiKey: String = API_KEY,
        @Query(LANGUAGE) language: String,
    ): Response<MoviesResponseData>

}