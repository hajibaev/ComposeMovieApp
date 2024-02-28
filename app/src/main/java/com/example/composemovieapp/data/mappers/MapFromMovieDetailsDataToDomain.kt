package com.example.composemovieapp.data.mappers

import com.example.composemovieapp.data.model.movie.MovieDetailsDataModel
import com.example.composemovieapp.data.model.movie.MovieGenresData
import com.example.composemovieapp.domain.base.Mapper
import com.example.composemovieapp.domain.model.movie.MovieDetailsDomainModel
import com.example.composemovieapp.domain.model.movie.MovieGenresDomain
import javax.inject.Inject

class MapFromMovieDetailsDataToDomain @Inject constructor(
    private val mapper: Mapper<MovieGenresData, MovieGenresDomain>
) :
    Mapper<MovieDetailsDataModel, MovieDetailsDomainModel> {

    override fun map(from: MovieDetailsDataModel) = from.run {
        MovieDetailsDomainModel(
            adult = adult,
            backdropPath = backdropPath.orEmpty(),
            budget = budget,
            id = id,
            language = language,
            title = title,
            overview = overview,
            popularity = popularity,
            posterPath = posterPath.orEmpty(),
            releaseDate = releaseDate,
            voteAverage = voteAverage,
            voteCount = voteCount,
            genres = genres.orEmpty().map { mapper.map(it) }
        )
    }

}