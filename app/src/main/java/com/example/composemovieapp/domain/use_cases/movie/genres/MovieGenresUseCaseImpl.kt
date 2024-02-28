package com.example.composemovieapp.domain.use_cases.movie.genres

import com.example.composemovieapp.domain.base.ResultModel
import com.example.composemovieapp.domain.model.movie.MovieGenresDomain
import com.example.composemovieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieGenresUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : MovieGenresUseCase {

    override suspend fun invoke(): ResultModel<List<MovieGenresDomain>> {
        return repository.fetchAllGenres()
        
    }

}