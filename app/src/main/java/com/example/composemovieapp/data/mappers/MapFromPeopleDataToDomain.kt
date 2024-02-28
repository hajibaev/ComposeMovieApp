package com.example.composemovieapp.data.mappers

import com.example.composemovieapp.data.model.movie.MovieData
import com.example.composemovieapp.data.model.person.PersonData
import com.example.composemovieapp.data.util.MovieDataConstants.POSTER_URL
import com.example.composemovieapp.domain.base.Mapper
import com.example.composemovieapp.domain.model.movie.MovieDomain
import com.example.composemovieapp.domain.model.people.PeopleDomain
import javax.inject.Inject

class MapFromPeopleDataToDomain @Inject constructor(
    private val mapperMovie: Mapper<MovieData, MovieDomain>
) : Mapper<PersonData, PeopleDomain> {

    override fun map(from: PersonData) = from.run {
        PeopleDomain(
            profilePath = POSTER_URL + profilePath.orEmpty(),
            adult = adult,
            id = id,
            knownFor = knownFor.map { mapperMovie.map(it) },
            name = name,
            popularity = popularity
        )
    }
}