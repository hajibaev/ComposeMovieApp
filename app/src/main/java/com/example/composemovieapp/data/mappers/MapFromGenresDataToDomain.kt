package com.example.composemovieapp.data.mappers

import com.example.composemovieapp.data.model.movie.MovieGenresData
import com.example.composemovieapp.domain.base.Mapper
import com.example.composemovieapp.domain.model.movie.MovieGenresDomain
import javax.inject.Inject

class MapFromGenresDataToDomain @Inject constructor() :
    Mapper<MovieGenresData, MovieGenresDomain> {

    override fun map(from: MovieGenresData) = from.run {
        MovieGenresDomain(
            id = id,
            name = name
        )
    }

}