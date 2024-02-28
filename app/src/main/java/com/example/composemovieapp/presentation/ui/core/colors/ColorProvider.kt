package com.example.composemovieapp.presentation.ui.core.colors

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalMovieColor = staticCompositionLocalOf<MovieColors> {
    error("No palette provided")
}

@Composable
fun ProvideMovieColors(
    colors: MovieColors,
    content: @Composable () -> Unit,
) {
    colors.update(colors)
    CompositionLocalProvider(
        values = arrayOf(LocalMovieColor provides colors),
        content = content
    )
}