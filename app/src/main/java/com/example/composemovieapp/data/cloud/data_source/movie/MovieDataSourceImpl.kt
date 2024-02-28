package com.example.composemovieapp.data.cloud.data_source.movie

import com.example.composemovieapp.data.base.BaseDataSource
import com.example.composemovieapp.data.cloud.service.MovieService
import com.example.composemovieapp.data.model.movie.MovieGenresResponseData
import com.example.composemovieapp.data.model.movie.MoviesResponseData
import com.example.composemovieapp.domain.base.ResultModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Locale
import javax.inject.Inject


class MovieDataSourceImpl @Inject constructor(
    private val service: MovieService
) : BaseDataSource(), MovieDataSource {

    private val locale = Locale.getDefault().language

    override suspend fun fetchAllTrending(
        page: Int,
    ): ResultModel<MoviesResponseData> = withContext(Dispatchers.IO) {
        invokeRequest {
            service.fetchAllTrending(
                language = locale,
                page = page,
            )
        }
    }

    override suspend fun fetchAllPopular(
        page: Int,
    ): ResultModel<MoviesResponseData> = withContext(Dispatchers.IO) {
        invokeRequest {
            service.fetchAllPopular(
                language = locale,
                page = page,
            )
        }
    }

    override suspend fun fetchAllNowPlaying(
        page: Int,
    ): ResultModel<MoviesResponseData> = withContext(Dispatchers.IO) {
        invokeRequest {
            service.fetchAllNowPlaying(
                language = locale,
                page = page,
            )
        }
    }

    override suspend fun fetchAllUpcoming(
        page: Int,
    ): ResultModel<MoviesResponseData> = withContext(Dispatchers.IO) {
        invokeRequest {
            service.fetchAllUpcoming(
                language = locale,
                page = page,
            )
        }
    }

    override suspend fun fetchAllTopRated(
        page: Int,
    ): ResultModel<MoviesResponseData> = withContext(Dispatchers.IO) {
        invokeRequest {
            service.fetchAllTopRated(
                language = locale,
                page = page,
            )
        }
    }

    override suspend fun fetchAllGenres(): ResultModel<MovieGenresResponseData> =
        withContext(Dispatchers.IO) {
            invokeRequest {
                service.fetchAllGenres(
                    language = locale,
                )
            }
        }

}