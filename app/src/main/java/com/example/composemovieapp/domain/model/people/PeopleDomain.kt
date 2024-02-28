package com.example.composemovieapp.domain.model.people

import com.example.composemovieapp.domain.model.movie.MovieDomain

data class PeopleDomain(
    val profilePath: String,
    val adult: Boolean,
    val id: Int,
    val knownFor: List<MovieDomain>,
    val name: String,
    val popularity: Double
)