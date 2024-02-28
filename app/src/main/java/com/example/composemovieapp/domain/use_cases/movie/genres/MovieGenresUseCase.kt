package com.example.composemovieapp.domain.use_cases.movie.genres

import com.example.composemovieapp.domain.base.ResultModel
import com.example.composemovieapp.domain.model.movie.MovieGenresDomain

interface MovieGenresUseCase {

    suspend fun invoke(): ResultModel<List<MovieGenresDomain>>

}