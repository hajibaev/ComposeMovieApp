package com.example.composemovieapp.presentation.model.movie

import androidx.compose.runtime.Immutable
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList

@Immutable
data class MovieUiModel(
    val movieId: Int,
    val poster: String,
    val popularity: Double,
    val title: String,
    val date: String,
    val genreIds: ImmutableList<Int>,
    val id: String
)
