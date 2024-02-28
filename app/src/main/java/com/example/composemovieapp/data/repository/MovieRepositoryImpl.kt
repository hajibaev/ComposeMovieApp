package com.example.composemovieapp.data.repository

import com.example.composemovieapp.data.base.BaseDataSource
import com.example.composemovieapp.data.cloud.data_source.movie.MovieDataSource
import com.example.composemovieapp.data.model.movie.MovieGenresData
import com.example.composemovieapp.domain.base.Mapper
import com.example.composemovieapp.domain.base.ResultModel
import com.example.composemovieapp.domain.model.movie.MovieGenresDomain
import com.example.composemovieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val dataSource: MovieDataSource,
    private val mapper: Mapper<MovieGenresData, MovieGenresDomain>
) : BaseDataSource(), MovieRepository {

    override suspend fun fetchAllGenres(): ResultModel<List<MovieGenresDomain>> {
        val response = dataSource.fetchAllGenres()
        return ResultModel(
            status = response.status,
            data = response.data?.genres?.map { mapper.map(it) },
            errorThrowable = response.errorThrowable
        )
    }

}