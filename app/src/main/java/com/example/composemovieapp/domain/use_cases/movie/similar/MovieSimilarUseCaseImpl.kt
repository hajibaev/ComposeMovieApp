package com.example.composemovieapp.domain.use_cases.movie.similar

import com.example.composemovieapp.domain.base.ResultModel
import com.example.composemovieapp.domain.model.movie.MovieDomain
import com.example.composemovieapp.domain.repository.MovieDetailsRepository
import javax.inject.Inject

class MovieSimilarUseCaseImpl @Inject constructor(
    private val repository: MovieDetailsRepository
) : MovieSimilarUseCase {

    override suspend fun invoke(id: Int): ResultModel<List<MovieDomain>> {
        val response = repository.fetchSimilarMovies(id)
        return ResultModel(
            status = response.status,
            data = response.data,
            errorThrowable = response.errorThrowable
        )
    }

}