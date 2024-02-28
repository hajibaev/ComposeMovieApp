package com.example.composemovieapp.data.repository

import com.example.composemovieapp.data.cloud.data_source.movie_details.MovieDetailsDataSource
import com.example.composemovieapp.data.model.movie.MovieData
import com.example.composemovieapp.data.model.movie.MovieDetailsDataModel
import com.example.composemovieapp.domain.base.Mapper
import com.example.composemovieapp.domain.base.ResultModel
import com.example.composemovieapp.domain.model.movie.MovieDetailsDomainModel
import com.example.composemovieapp.domain.model.movie.MovieDomain
import com.example.composemovieapp.domain.repository.MovieDetailsRepository
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(
    private val source: MovieDetailsDataSource,
    private val mapperToMovieDetailsDomain: Mapper<MovieDetailsDataModel, MovieDetailsDomainModel>,
    private val mapperToMovieDomain: Mapper<MovieData, MovieDomain>
) : MovieDetailsRepository {

    override suspend fun fetchMovieDetails(id: Int): ResultModel<MovieDetailsDomainModel> {
        val response = source.fetchMovieDetails(id)
        return ResultModel(
            status = response.status,
            data = response.data?.let { mapperToMovieDetailsDomain.map(it) },
            errorThrowable = response.errorThrowable
        )
    }

    override suspend fun fetchSimilarMovies(id: Int): ResultModel<List<MovieDomain>> {
        val response = source.fetchSimilarMovies(id)
        return ResultModel(
            status = response.status,
            data = response.data?.movies?.map { mapperToMovieDomain.map(it) },
            errorThrowable = response.errorThrowable
        )
    }

    override suspend fun fetchRecommendationsMovies(id: Int): ResultModel<List<MovieDomain>> {
        val response = source.fetchRecommendationsMovies(id)
        return ResultModel(
            status = response.status,
            data = response.data?.movies?.map { mapperToMovieDomain.map(it) },
            errorThrowable = response.errorThrowable
        )
    }

}