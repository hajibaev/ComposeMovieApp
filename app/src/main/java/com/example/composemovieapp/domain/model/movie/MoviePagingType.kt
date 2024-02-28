package com.example.composemovieapp.domain.model.movie

import androidx.compose.runtime.Immutable

@Immutable
enum class MoviePagingType {
    POPULAR,
    NOW_PLAYING,
    TOP_RATED,
    UPCOMING,
    TRENDING,
}
