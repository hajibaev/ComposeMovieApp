package com.example.composemovieapp.domain.use_cases.movie.similar

import com.example.composemovieapp.domain.base.ResultModel
import com.example.composemovieapp.domain.model.movie.MovieDomain

interface MovieSimilarUseCase {

    suspend operator fun invoke(id: Int): ResultModel<List<MovieDomain>>

}