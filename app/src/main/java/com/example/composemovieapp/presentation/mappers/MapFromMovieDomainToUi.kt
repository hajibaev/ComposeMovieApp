package com.example.composemovieapp.presentation.mappers

import com.example.composemovieapp.domain.base.Mapper
import com.example.composemovieapp.domain.model.movie.MovieDomain
import com.example.composemovieapp.presentation.model.movie.MovieUiModel
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList
import java.util.UUID
import javax.inject.Inject

class MapFromMovieDomainToUi @Inject constructor() : Mapper<MovieDomain, MovieUiModel> {
    override fun map(from: MovieDomain) = from.run {
        MovieUiModel(
            poster = posterPath,
            popularity = voteAverage,
            title = title,
            date = releaseDate,
            id = UUID.randomUUID().toString(),
            genreIds = ImmutableList.copyOf(this.genreIds),
            movieId = movieId
        )
    }
}