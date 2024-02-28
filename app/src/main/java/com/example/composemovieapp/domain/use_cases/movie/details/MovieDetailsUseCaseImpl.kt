package com.example.composemovieapp.domain.use_cases.movie.details

import com.example.composemovieapp.domain.base.ResultModel
import com.example.composemovieapp.domain.model.movie.MovieDetailsDomainModel
import com.example.composemovieapp.domain.repository.MovieDetailsRepository
import javax.inject.Inject

class MovieDetailsUseCaseImpl @Inject constructor(
    private val repository: MovieDetailsRepository
) : MovieDetailsUseCase {

    override suspend fun invoke(id: Int): ResultModel<MovieDetailsDomainModel> {
        return repository.fetchMovieDetails(id)
    }
}