package com.example.composemovieapp.presentation.ui.core.typography

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import com.example.composemovieapp.presentation.util.fonts.bodyLargeFontSize
import com.example.composemovieapp.presentation.util.fonts.bodyLargeLetterSpacing
import com.example.composemovieapp.presentation.util.fonts.bodyLargeLineHeight
import com.example.composemovieapp.presentation.util.fonts.bodyMediumFontSize
import com.example.composemovieapp.presentation.util.fonts.bodyMediumLetterSpacing
import com.example.composemovieapp.presentation.util.fonts.bodyMediumLineHeight
import com.example.composemovieapp.presentation.util.fonts.bodySmallFontSize
import com.example.composemovieapp.presentation.util.fonts.bodySmallLetterSpacing
import com.example.composemovieapp.presentation.util.fonts.bodySmallLineHeight
import com.example.composemovieapp.presentation.util.fonts.interMedium
import com.example.composemovieapp.presentation.util.fonts.interRegular
import com.example.composemovieapp.presentation.util.fonts.labelLargeFontSize
import com.example.composemovieapp.presentation.util.fonts.labelLargeLetterSpacing
import com.example.composemovieapp.presentation.util.fonts.labelLargeLineHeight
import com.example.composemovieapp.presentation.util.fonts.labelMediumFontSize
import com.example.composemovieapp.presentation.util.fonts.labelMediumLetterSpacing
import com.example.composemovieapp.presentation.util.fonts.labelMediumLineHeight
import com.example.composemovieapp.presentation.util.fonts.labelSmallFontSize
import com.example.composemovieapp.presentation.util.fonts.labelSmallLetterSpacing
import com.example.composemovieapp.presentation.util.fonts.labelSmallLineHeight
import com.example.composemovieapp.presentation.util.fonts.titleLargeFontSize
import com.example.composemovieapp.presentation.util.fonts.titleLargeLetterSpacing
import com.example.composemovieapp.presentation.util.fonts.titleLargeLineHeight
import com.example.composemovieapp.presentation.util.fonts.titleMediumFontSize
import com.example.composemovieapp.presentation.util.fonts.titleMediumLetterSpacing
import com.example.composemovieapp.presentation.util.fonts.titleMediumLineHeight
import com.example.composemovieapp.presentation.util.fonts.titleSmallFontSize
import com.example.composemovieapp.presentation.util.fonts.titleSmallLetterSpacing
import com.example.composemovieapp.presentation.util.fonts.titleSmallLineHeight

@Immutable
class MovieTypography {

    /** Title styles **/
    val titleLarge: TextStyle = titleLargeSet
    val titleMedium: TextStyle = titleMediumSet
    val titleSmall: TextStyle = titleSmallSet

    /** Label styles **/
    val labelLarge: TextStyle = labelLargeSet
    val labelMedium: TextStyle = labelMediumSet
    val labelSmall: TextStyle = labelSmallSet

    /** Body styles **/
    val bodyLarge: TextStyle = bodyLargeSet
    val bodyMedium: TextStyle = bodyMediumSet
    val bodySmall: TextStyle = bodySmallSet
}

/** Title styles **/
val titleLargeSet = TextStyle(
    fontFamily = interRegular,
    letterSpacing = titleLargeLetterSpacing,
    fontSize = titleLargeFontSize,
    lineHeight = titleLargeLineHeight,
)
val titleMediumSet = TextStyle(
    fontFamily = interMedium,
    letterSpacing = titleMediumLetterSpacing,
    fontSize = titleMediumFontSize,
    lineHeight = titleMediumLineHeight,
)

val titleSmallSet = TextStyle(
    fontFamily = interMedium,
    letterSpacing = titleSmallLetterSpacing,
    fontSize = titleSmallFontSize,
    lineHeight = titleSmallLineHeight,
)


/** Label styles **/
val labelLargeSet = TextStyle(
    fontFamily = interMedium,
    letterSpacing = labelLargeLetterSpacing,
    fontSize = labelLargeFontSize,
    lineHeight = labelLargeLineHeight,
)
val labelMediumSet = TextStyle(
    fontFamily = interMedium,
    letterSpacing = labelMediumLetterSpacing,
    fontSize = labelMediumFontSize,
    lineHeight = labelMediumLineHeight,
)
val labelSmallSet = TextStyle(
    fontFamily = interMedium,
    letterSpacing = labelSmallLetterSpacing,
    fontSize = labelSmallFontSize,
    lineHeight = labelSmallLineHeight,
)


/** Body styles **/
val bodyLargeSet = TextStyle(
    fontFamily = interRegular,
    letterSpacing = bodyLargeLetterSpacing,
    fontSize = bodyLargeFontSize,
    lineHeight = bodyLargeLineHeight,
)
val bodyMediumSet = TextStyle(
    fontFamily = interRegular,
    letterSpacing = bodyMediumLetterSpacing,
    fontSize = bodyMediumFontSize,
    lineHeight = bodyMediumLineHeight,
)
val bodySmallSet = TextStyle(
    fontFamily = interRegular,
    letterSpacing = bodySmallLetterSpacing,
    fontSize = bodySmallFontSize,
    lineHeight = bodySmallLineHeight,
)