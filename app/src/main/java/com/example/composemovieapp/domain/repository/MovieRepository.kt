package com.example.composemovieapp.domain.repository

import com.example.composemovieapp.domain.base.ResultModel
import com.example.composemovieapp.domain.model.movie.MovieGenresDomain

interface MovieRepository {

    suspend fun fetchAllGenres(): ResultModel<List<MovieGenresDomain>>

}