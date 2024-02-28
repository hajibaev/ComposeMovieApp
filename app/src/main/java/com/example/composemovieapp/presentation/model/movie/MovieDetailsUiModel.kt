package com.example.composemovieapp.presentation.model.movie

import androidx.compose.runtime.Immutable
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList

@Immutable
data class MovieDetailsUiModel(
    val adult: Boolean,
    val backdropPath: String,
    val budget: Int,
    val genres: ImmutableList<MovieGenresUiModel>,
    val id: Int,
    val language: String,
    val title: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val voteAverage: Double,
    val voteCount: Int
) {

//    companion object {
//        val unknown = MovieDetailsUiModel(
//            adult = false,
//            backdropPath = String(),
//            budget = 0,
//            genres = listOf(
//                MovieGenresUiModel(
//                    id = 0,
//                    name = String(),
//                )
//            ),
//            id = 0,
//            language = String(),
//            title = String(),
//            overview = String(),
//            popularity = 0.0,
//            posterPath = String(),
//            releaseDate = String(),
//            voteAverage = 0.0,
//            voteCount = 0,
//        )
//    }

}