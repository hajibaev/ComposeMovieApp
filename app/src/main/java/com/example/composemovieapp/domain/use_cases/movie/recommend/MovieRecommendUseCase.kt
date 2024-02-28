package com.example.composemovieapp.domain.use_cases.movie.recommend

import com.example.composemovieapp.domain.base.ResultModel
import com.example.composemovieapp.domain.model.movie.MovieDomain


interface MovieRecommendUseCase {

    suspend operator fun invoke(id: Int): ResultModel<List<MovieDomain>>

}