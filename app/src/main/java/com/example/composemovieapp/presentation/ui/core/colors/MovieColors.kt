package com.example.composemovieapp.presentation.ui.core.colors

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Stable
class MovieColors(
    colorPrimary: Color,
    colorOnPrimary: Color,
    colorOverlay: Color,
    colorPrimaryContainer: Color,
    colorOnPrimaryContainer: Color,
    colorPrimaryFixed: Color,
    colorOnPrimaryFixed: Color,
    colorPrimaryFixedDim: Color,
    colorOnPrimaryFixedVariant: Color,
    colorSecondary: Color,
    colorOnSecondary: Color,
    colorSecondaryContainer: Color,
    colorOnSecondaryContainer: Color,
    colorSecondaryFixed: Color,
    colorOnSecondaryFixed: Color,
    colorSecondaryFixedDim: Color,
    colorOnSecondaryFixedVariant: Color,
    colorTertiary: Color,
    colorOnTertiary: Color,
    colorTertiaryContainer: Color,
    colorOnTertiaryContainer: Color,
    colorError: Color,
    colorOnError: Color,
    colorErrorContainer: Color,
    colorOnErrorContainer: Color,
    colorOutline: Color,
    colorOnBackground: Color,
    colorSurface: Color,
    colorOnSurface: Color,
    colorSurfaceVariant: Color,
    colorOnSurfaceVariant: Color,
    colorSurfaceInverse: Color,
    colorOnSurfaceInverse: Color,
    colorInversePrimary: Color,
    colorOutlineVariant: Color,
    colorSurfaceContainerHighest: Color,
    colorSurfaceContainerHigh: Color,
    colorSurfaceContainer: Color,
    colorSurfaceContainerLow: Color,
    colorSurfaceContainerLowest: Color,
    colorSurfaceBright: Color,
    colorSurfaceDim: Color,
    colorInverseSurface: Color,
    colorInverseOnSurface: Color,
    isDark: Boolean,
) {
    var colorPrimary by mutableStateOf(colorPrimary)
        private set

    var colorOnPrimary by mutableStateOf(colorOnPrimary)
        private set

    var colorOverlay by mutableStateOf(colorOverlay)
        private set

    var colorPrimaryContainer by mutableStateOf(colorPrimaryContainer)
        private set

    var colorOnPrimaryContainer by mutableStateOf(colorOnPrimaryContainer)
        private set

    var colorPrimaryFixed by mutableStateOf(colorPrimaryFixed)
        private set

    var colorOnPrimaryFixed by mutableStateOf(colorOnPrimaryFixed)
        private set

    var colorPrimaryFixedDim by mutableStateOf(colorPrimaryFixedDim)
        private set

    var colorOnPrimaryFixedVariant by mutableStateOf(colorOnPrimaryFixedVariant)
        private set

    var colorSecondary by mutableStateOf(colorSecondary)
        private set

    var colorOnSecondary by mutableStateOf(colorOnSecondary)
        private set

    var colorSecondaryContainer by mutableStateOf(colorSecondaryContainer)
        private set

    var colorOnSecondaryContainer by mutableStateOf(colorOnSecondaryContainer)
        private set

    var colorSecondaryFixed by mutableStateOf(colorSecondaryFixed)
        private set

    var colorOnSecondaryFixed by mutableStateOf(colorOnSecondaryFixed)
        private set

    var colorSecondaryFixedDim by mutableStateOf(colorSecondaryFixedDim)
        private set

    var colorOnSecondaryFixedVariant by mutableStateOf(colorOnSecondaryFixedVariant)
        private set

    var colorTertiary by mutableStateOf(colorTertiary)
        private set

    var colorOnTertiary by mutableStateOf(colorOnTertiary)
        private set

    var colorTertiaryContainer by mutableStateOf(colorTertiaryContainer)
        private set

    var colorOnTertiaryContainer by mutableStateOf(colorOnTertiaryContainer)
        private set

    var colorError by mutableStateOf(colorError)
        private set

    var colorOnError by mutableStateOf(colorOnError)
        private set

    var colorErrorContainer by mutableStateOf(colorErrorContainer)
        private set

    var colorOnErrorContainer by mutableStateOf(colorOnErrorContainer)
        private set

    var colorOutline by mutableStateOf(colorOutline)
        private set

    var colorOnBackground by mutableStateOf(colorOnBackground)
        private set

    var colorSurface by mutableStateOf(colorSurface)
        private set

    var colorOnSurface by mutableStateOf(colorOnSurface)
        private set

    var colorSurfaceVariant by mutableStateOf(colorSurfaceVariant)
        private set

    var colorOnSurfaceVariant by mutableStateOf(colorOnSurfaceVariant)
        private set

    var colorSurfaceInverse by mutableStateOf(colorSurfaceInverse)
        private set

    var colorOnSurfaceInverse by mutableStateOf(colorOnSurfaceInverse)
        private set

    var colorPrimaryInverse by mutableStateOf(colorInversePrimary)
        private set

    var colorOutlineVariant by mutableStateOf(colorOutlineVariant)
        private set

    var colorSurfaceContainerHighest by mutableStateOf(colorSurfaceContainerHighest)
        private set

    var colorSurfaceContainerHigh by mutableStateOf(colorSurfaceContainerHigh)
        private set

    var colorSurfaceContainer by mutableStateOf(colorSurfaceContainer)
        private set

    var colorSurfaceContainerLow by mutableStateOf(colorSurfaceContainerLow)
        private set

    var colorSurfaceContainerLowest by mutableStateOf(colorSurfaceContainerLowest)
        private set

    var colorInverseSurface by mutableStateOf(colorInverseSurface)
        private set

    var colorInverseOnSurface by mutableStateOf(colorInverseOnSurface)
        private set

    var colorSurfaceBright by mutableStateOf(colorSurfaceBright)
        private set

    var colorSurfaceDim by mutableStateOf(colorSurfaceDim)
        private set

    var isDark by mutableStateOf(isDark)
        private set

    fun update(other: MovieColors) {
        colorPrimary = other.colorPrimary
        colorOnPrimary = other.colorOnPrimary
        colorOverlay = other.colorOverlay
        colorPrimaryContainer = other.colorPrimaryContainer
        colorOnPrimaryContainer = other.colorOnPrimaryContainer
        colorPrimaryFixed = other.colorPrimaryFixed
        colorOnPrimaryFixed = other.colorOnPrimaryFixed
        colorPrimaryFixedDim = other.colorPrimaryFixedDim
        colorOnPrimaryFixedVariant = other.colorOnPrimaryFixedVariant
        colorSecondary = other.colorSecondary
        colorOnSecondary = other.colorOnSecondary
        colorSecondaryContainer = other.colorSecondaryContainer
        colorOnSecondaryContainer = other.colorOnSecondaryContainer
        colorSecondaryFixed = other.colorSecondaryFixed
        colorOnSecondaryFixed = other.colorOnSecondaryFixed
        colorSecondaryFixedDim = other.colorSecondaryFixedDim
        colorOnSecondaryFixedVariant = other.colorOnSecondaryFixedVariant
        colorTertiary = other.colorTertiary
        colorOnTertiary = other.colorOnTertiary
        colorTertiaryContainer = other.colorTertiaryContainer
        colorOnTertiaryContainer = other.colorOnTertiaryContainer
        colorError = other.colorError
        colorOnError = other.colorOnError
        colorErrorContainer = other.colorErrorContainer
        colorOnErrorContainer = other.colorOnErrorContainer
        colorOutline = other.colorOutline
        colorOnBackground = other.colorOnBackground
        colorSurface = other.colorSurface
        colorOnSurface = other.colorOnSurface
        colorSurfaceVariant = other.colorSurfaceVariant
        colorOnSurfaceVariant = other.colorOnSurfaceVariant
        colorSurfaceInverse = other.colorSurfaceInverse
        colorOnSurfaceInverse = other.colorOnSurfaceInverse
        colorPrimaryInverse = other.colorPrimaryInverse
        colorOutlineVariant = other.colorOutlineVariant
        colorSurfaceContainerHighest = other.colorSurfaceContainerHighest
        colorSurfaceContainerHigh = other.colorSurfaceContainerHigh
        colorSurfaceContainer = other.colorSurfaceContainer
        colorSurfaceContainerLow = other.colorSurfaceContainerLow
        colorSurfaceContainerLowest = other.colorSurfaceContainerLowest
        colorSurfaceBright = other.colorSurfaceBright
        colorSurfaceDim = other.colorSurfaceDim
        colorInverseSurface = other.colorInverseSurface
        colorInverseOnSurface = other.colorInverseOnSurface
        isDark = other.isDark
    }
}

fun debugColors(
    darkTheme: Boolean,
    darkPalette: MovieColors,
    lightPalette: MovieColors,
) = if (darkTheme) darkColorScheme(
    primary = darkPalette.colorPrimary,
    onPrimary = darkPalette.colorOnPrimary,
    primaryContainer = darkPalette.colorPrimaryContainer,
    onPrimaryContainer = darkPalette.colorOnPrimaryContainer,
    inversePrimary = darkPalette.colorPrimaryInverse,
    secondary = darkPalette.colorSecondary,
    onSecondary = darkPalette.colorOnSecondary,
    secondaryContainer = darkPalette.colorSecondaryContainer,
    onSecondaryContainer = darkPalette.colorOnSecondaryContainer,
    tertiary = darkPalette.colorTertiary,
    onTertiary = darkPalette.colorOnTertiary,
    tertiaryContainer = darkPalette.colorTertiaryContainer,
    onTertiaryContainer = darkPalette.colorOnTertiaryContainer,
    onBackground = darkPalette.colorOnBackground,
    background = darkPalette.colorSurface,
    surface = darkPalette.colorSurface,
    onSurface = darkPalette.colorOnSurface,
    surfaceVariant = darkPalette.colorSurfaceVariant,
    onSurfaceVariant = darkPalette.colorOnSurfaceVariant,
    inverseSurface = darkPalette.colorInverseSurface,
    inverseOnSurface = darkPalette.colorInverseOnSurface,
    error = darkPalette.colorError,
    onError = darkPalette.colorOnError,
    errorContainer = darkPalette.colorErrorContainer,
    onErrorContainer = darkPalette.colorOnErrorContainer,
    outline = darkPalette.colorOutline,
    outlineVariant = darkPalette.colorOutlineVariant,
) else lightColorScheme(
    primary = lightPalette.colorPrimary,
    onPrimary = lightPalette.colorOnPrimary,
    primaryContainer = lightPalette.colorPrimaryContainer,
    onPrimaryContainer = lightPalette.colorOnPrimaryContainer,
    inversePrimary = lightPalette.colorPrimaryInverse,
    secondary = lightPalette.colorSecondary,
    onSecondary = lightPalette.colorOnSecondary,
    secondaryContainer = lightPalette.colorSecondaryContainer,
    onSecondaryContainer = lightPalette.colorOnSecondaryContainer,
    tertiary = lightPalette.colorTertiary,
    onTertiary = lightPalette.colorOnTertiary,
    tertiaryContainer = lightPalette.colorTertiaryContainer,
    onTertiaryContainer = lightPalette.colorOnTertiaryContainer,
    onBackground = lightPalette.colorOnBackground,
    background = lightPalette.colorSurface,
    surface = lightPalette.colorSurface,
    onSurface = lightPalette.colorOnSurface,
    surfaceVariant = lightPalette.colorSurfaceVariant,
    onSurfaceVariant = lightPalette.colorOnSurfaceVariant,
    inverseSurface = lightPalette.colorInverseSurface,
    inverseOnSurface = lightPalette.colorInverseOnSurface,
    error = lightPalette.colorError,
    onError = lightPalette.colorOnError,
    errorContainer = lightPalette.colorErrorContainer,
    onErrorContainer = lightPalette.colorOnErrorContainer,
    outline = lightPalette.colorOutline,
    outlineVariant = lightPalette.colorOutlineVariant,
)