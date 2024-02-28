package com.example.composemovieapp.presentation.mappers

import com.example.composemovieapp.domain.base.Mapper
import com.example.composemovieapp.domain.model.movie.MovieDetailsDomainModel
import com.example.composemovieapp.domain.model.movie.MovieGenresDomain
import com.example.composemovieapp.presentation.model.movie.MovieDetailsUiModel
import com.example.composemovieapp.presentation.model.movie.MovieGenresUiModel
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList
import javax.inject.Inject

class MapFromMovieDetailsDomainToUi @Inject constructor(
    private val mapper: Mapper<MovieGenresDomain, MovieGenresUiModel>
) : Mapper<MovieDetailsDomainModel, MovieDetailsUiModel> {
    override fun map(from: MovieDetailsDomainModel) = from.run {
        MovieDetailsUiModel(
            adult = adult,
            backdropPath = backdropPath,
            budget = budget,
            id = id,
            language = language,
            title = title,
            overview = overview,
            popularity = popularity,
            posterPath = posterPath,
            releaseDate = releaseDate,
            voteAverage = voteAverage,
            voteCount = voteCount,
            genres = ImmutableList.copyOf(genres.map { mapper.map(it) })
        )
    }
}