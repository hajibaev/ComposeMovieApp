package com.example.composemovieapp.presentation.model.app

import androidx.compose.runtime.Immutable
import com.example.composemovieapp.R
import java.util.Random

@Immutable
data class AppearanceModel(
    val id: Int,
    val title: Int,
    val isDark: Boolean,
    val theme: AppTheme
)

fun appearanceItems(isDarkTheme: Boolean): List<AppearanceModel> {
    val random = Random()
    return listOf(
        AppearanceModel(
            id = random.nextInt(),
            title = R.string.color_theme_light,
            isDark = !isDarkTheme,
            theme = AppTheme.Light
        ),
        AppearanceModel(
            id = random.nextInt(),
            title = R.string.color_theme_dark,
            isDark = isDarkTheme,
            theme = AppTheme.Dark
        )
    )

}