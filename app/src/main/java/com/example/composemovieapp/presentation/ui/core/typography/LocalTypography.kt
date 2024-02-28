package com.example.composemovieapp.presentation.ui.core.typography

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

val LocalMovieTypography = staticCompositionLocalOf<MovieTypography> {
    error("No typography provided")
}

@Composable
fun ProvideMovieTypography(
    friendSyncTypography: MovieTypography,
    content: @Composable () -> Unit,
) {
    val styles = remember { friendSyncTypography }
    CompositionLocalProvider(
        values = arrayOf(LocalMovieTypography provides styles),
        content = content
    )
}