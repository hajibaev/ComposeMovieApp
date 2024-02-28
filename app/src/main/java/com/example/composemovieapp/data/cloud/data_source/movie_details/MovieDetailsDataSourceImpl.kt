package com.example.composemovieapp.data.cloud.data_source.movie_details

import com.example.composemovieapp.data.base.BaseDataSource
import com.example.composemovieapp.data.cloud.service.MovieDetailsService
import com.example.composemovieapp.data.model.movie.MovieDetailsDataModel
import com.example.composemovieapp.data.model.movie.MoviesResponseData
import com.example.composemovieapp.domain.base.ResultModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Locale
import javax.inject.Inject

class MovieDetailsDataSourceImpl @Inject constructor(
    private val service: MovieDetailsService,
) : BaseDataSource(), MovieDetailsDataSource {

    private val locale = Locale.getDefault().language

    override suspend fun fetchMovieDetails(id: Int): ResultModel<MovieDetailsDataModel> =
        withContext(Dispatchers.IO) {
            invokeRequest {
                service.fetchMovieDetails(
                    id = id,
                    language = locale
                )
            }
        }

    override suspend fun fetchSimilarMovies(id: Int): ResultModel<MoviesResponseData> =
        withContext(Dispatchers.IO) {
            invokeRequest {
                service.fetchSimilarMovies(
                    id = id,
                    language = locale
                )
            }
        }

    override suspend fun fetchRecommendationsMovies(id: Int): ResultModel<MoviesResponseData> =
        withContext(Dispatchers.IO) {
            invokeRequest {
                service.fetchRecommendationsMovies(
                    id = id,
                    language = locale
                )
            }
        }

}