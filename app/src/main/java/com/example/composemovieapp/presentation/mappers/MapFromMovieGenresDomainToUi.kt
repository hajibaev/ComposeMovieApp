package com.example.composemovieapp.presentation.mappers

import com.example.composemovieapp.domain.base.Mapper
import com.example.composemovieapp.domain.model.movie.MovieGenresDomain
import com.example.composemovieapp.presentation.model.movie.MovieGenresUiModel
import javax.inject.Inject

class MapFromMovieGenresDomainToUi @Inject constructor() :
    Mapper<MovieGenresDomain, MovieGenresUiModel> {
    override fun map(from: MovieGenresDomain) = from.run {
        MovieGenresUiModel(
            id = id,
            name = name
        )
    }
}