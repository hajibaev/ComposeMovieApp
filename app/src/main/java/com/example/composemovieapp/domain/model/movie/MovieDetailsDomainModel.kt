package com.example.composemovieapp.domain.model.movie

data class MovieDetailsDomainModel(
    val adult: Boolean,
    val backdropPath: String,
    val budget: Int,
    val genres: List<MovieGenresDomain>,
    val id: Int,
    val language: String,
    val title: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val voteAverage: Double,
    val voteCount: Int
)
