package com.example.composemovieapp.domain.use_cases.movie.recommend

import com.example.composemovieapp.domain.base.ResultModel
import com.example.composemovieapp.domain.model.movie.MovieDomain
import com.example.composemovieapp.domain.repository.MovieDetailsRepository
import javax.inject.Inject

class MovieRecommendUseCaseImpl @Inject constructor(
    private val repository: MovieDetailsRepository
) : MovieRecommendUseCase {

    override suspend fun invoke(id: Int): ResultModel<List<MovieDomain>> {
        val response = repository.fetchRecommendationsMovies(id)
        return ResultModel(
            status = response.status,
            data = response.data,
            errorThrowable = response.errorThrowable
        )
    }
}