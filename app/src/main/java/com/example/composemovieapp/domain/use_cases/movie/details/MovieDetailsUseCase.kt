package com.example.composemovieapp.domain.use_cases.movie.details

import com.example.composemovieapp.domain.base.ResultModel
import com.example.composemovieapp.domain.model.movie.MovieDetailsDomainModel

interface MovieDetailsUseCase {

    suspend operator fun invoke(id: Int): ResultModel<MovieDetailsDomainModel>

}