package com.example.composemovieapp.presentation.ui.core.colors

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.composemovieapp.presentation.ui.core.typography.LocalMovieTypography
import com.example.composemovieapp.presentation.ui.core.typography.MovieTypography
import com.example.composemovieapp.presentation.ui.core.typography.ProvideMovieTypography


internal val LocalThemeIsDark = compositionLocalOf { mutableStateOf(true) }

@Composable
fun MovieTheme(
    content: @Composable () -> Unit,
) {
    val typography = MovieTypography()
    val systemIsDark = isSystemInDarkTheme()
    val isDarkState = remember { mutableStateOf(systemIsDark) }

    CompositionLocalProvider(
        LocalThemeIsDark provides isDarkState
    ) {
        val isDark by isDarkState
        val colors = if (isDark) darkPalette else lightPalette

        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                val window = (view.context as Activity).window
                window.statusBarColor = colors.colorSurface.toArgb()
                WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !isDark
            }
        }

        CompositionLocalProvider {
            ProvideMovieTypography(typography) {
                ProvideMovieColors(colors) {
                    MaterialTheme(
                        colorScheme = debugColors(isDark, darkPalette, lightPalette),
                        content = content
                    )
                }
            }
        }
    }
}



object MovieTheme {
    val colors: MovieColors
        @Composable
        get() = LocalMovieColor.current

    val typography: MovieTypography
        @Composable
        get() = LocalMovieTypography.current
}