package com.example.composemovieapp.data.cloud.service

import com.example.composemovieapp.data.model.movie.MovieGenresResponseData
import com.example.composemovieapp.data.model.movie.MoviesResponseData
import com.example.composemovieapp.data.util.MovieDataConstants.APIKEY
import com.example.composemovieapp.data.util.MovieDataConstants.GENRES_GET
import com.example.composemovieapp.data.util.MovieDataConstants.LANGUAGE
import com.example.composemovieapp.data.util.MovieDataConstants.NOW_PLAYING
import com.example.composemovieapp.data.util.MovieDataConstants.PAGE
import com.example.composemovieapp.data.util.MovieDataConstants.POPULAR
import com.example.composemovieapp.data.util.MovieDataConstants.TOP_RATED
import com.example.composemovieapp.data.util.MovieDataConstants.TRENDING
import com.example.composemovieapp.data.util.MovieDataConstants.UPCOMING
import com.example.composemovieapp.di.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET(TRENDING)
    suspend fun fetchAllTrending(
        @Query(APIKEY) apiKey: String = API_KEY,
        @Query(LANGUAGE) language: String,
        @Query(PAGE) page: Int,
    ): Response<MoviesResponseData>

    @GET(POPULAR)
    suspend fun fetchAllPopular(
        @Query(APIKEY) apiKey: String = API_KEY,
        @Query(LANGUAGE) language: String,
        @Query(PAGE) page: Int,
    ): Response<MoviesResponseData>

    @GET(NOW_PLAYING)
    suspend fun fetchAllNowPlaying(
        @Query(APIKEY) apiKey: String = API_KEY,
        @Query(LANGUAGE) language: String,
        @Query(PAGE) page: Int,
    ): Response<MoviesResponseData>

    @GET(UPCOMING)
    suspend fun fetchAllUpcoming(
        @Query(APIKEY) apiKey: String = API_KEY,
        @Query(LANGUAGE) language: String,
        @Query(PAGE) page: Int,
    ): Response<MoviesResponseData>

    @GET(TOP_RATED)
    suspend fun fetchAllTopRated(
        @Query(APIKEY) apiKey: String = API_KEY,
        @Query(LANGUAGE) language: String,
        @Query(PAGE) page: Int,
    ): Response<MoviesResponseData>

    @GET(GENRES_GET)
    suspend fun fetchAllGenres(
        @Query(APIKEY) apiKey: String = API_KEY,
        @Query(LANGUAGE) language: String,
    ): Response<MovieGenresResponseData>

}