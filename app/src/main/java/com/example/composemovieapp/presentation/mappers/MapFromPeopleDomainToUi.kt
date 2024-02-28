package com.example.composemovieapp.presentation.mappers

import com.example.composemovieapp.domain.base.Mapper
import com.example.composemovieapp.domain.model.movie.MovieDomain
import com.example.composemovieapp.domain.model.people.PeopleDomain
import com.example.composemovieapp.presentation.model.movie.MovieUiModel
import com.example.composemovieapp.presentation.model.people.PeopleUiModel
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList
import java.util.UUID
import javax.inject.Inject

class MapFromPeopleDomainToUi @Inject constructor(
    private val movieMapper: Mapper<MovieDomain, MovieUiModel>,
) : Mapper<PeopleDomain, PeopleUiModel> {

    override fun map(from: PeopleDomain) = from.run {
        PeopleUiModel(
            profilePath = profilePath,
            adult = adult,
            id = id,
            knownFor = ImmutableList.copyOf(this.knownFor.map { movieMapper.map(it) }),
            name = name,
            popularity = popularity,
            randomId = UUID.randomUUID().toString()
        )
    }

}