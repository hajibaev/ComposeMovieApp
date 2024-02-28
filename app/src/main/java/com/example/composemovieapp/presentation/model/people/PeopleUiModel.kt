package com.example.composemovieapp.presentation.model.people

import androidx.compose.runtime.Immutable
import com.example.composemovieapp.presentation.model.movie.MovieUiModel
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList

@Immutable
class PeopleUiModel(
    val profilePath: String,
    val adult: Boolean,
    val id: Int,
    val knownFor: ImmutableList<MovieUiModel>,
    val name: String,
    val popularity: Double,
    val randomId: String,
)