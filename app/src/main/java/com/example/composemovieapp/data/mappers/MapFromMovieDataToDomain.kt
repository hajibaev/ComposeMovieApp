package com.example.composemovieapp.data.mappers

import com.example.composemovieapp.data.model.movie.MovieData
import com.example.composemovieapp.data.util.MovieDataConstants.POSTER_URL
import com.example.composemovieapp.domain.base.Mapper
import com.example.composemovieapp.domain.model.movie.MovieDomain
import javax.inject.Inject

class MapFromMovieDataToDomain @Inject constructor() : Mapper<MovieData, MovieDomain> {

    override fun map(from: MovieData) = from.run {
        MovieDomain(
            movieId = movieId,
            posterPath = POSTER_URL + posterPath.orEmpty(),
            title = title.orEmpty(),
            voteAverage = voteAverage,
            releaseDate = releaseDate.orEmpty(),
            genreIds = genreIds.orEmpty(),
        )
    }

}
