package com.example.composemovieapp.domain.model.movie

data class MovieDomain(
    val movieId: Int,
    val posterPath: String,
    val title: String,
    val voteAverage: Double,
    val releaseDate: String,
    val genreIds: List<Int>,
)