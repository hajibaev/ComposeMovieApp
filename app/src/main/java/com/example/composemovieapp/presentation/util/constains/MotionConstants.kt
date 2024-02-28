package com.example.composemovieapp.presentation.util.constains

import androidx.compose.ui.unit.Dp
import com.example.composemovieapp.presentation.util.fonts.dp30

data object MotionConstants {
    const val DefaultMotionDuration: Int = 400
    const val ScreenDuration: Int = DefaultMotionDuration + 150
    const val DefaultFadeInDuration: Int = 150
    const val DefaultFadeOutDuration: Int = 75
    val DefaultSlideDistance: Dp = dp30
}
