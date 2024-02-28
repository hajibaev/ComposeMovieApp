package com.example.composemovieapp.presentation.ui.components.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import com.example.composemovieapp.data.util.MovieDataConstants.EMPTY_ID
import com.example.composemovieapp.presentation.ui.core.colors.MovieTheme
import com.example.composemovieapp.presentation.util.fonts.dp20
import com.example.composemovieapp.presentation.util.fonts.dp8

@Composable
fun CategoryItem(
    id: Int,
    title: String,
    selectedId: () -> Int,
    changeMovieGenres: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(dp8))
            .padding(horizontal = dp8),
        colors = CardDefaults.cardColors(
            containerColor = if (selectedId.invoke() == id) MovieTheme.colors.colorPrimary
            else MovieTheme.colors.colorSurfaceContainerLow
        )
    ) {
        Text(
            text = title,
            style = MovieTheme.typography.titleMedium,
            color = if (selectedId.invoke() == id) MovieTheme.colors.colorOnPrimary
            else MovieTheme.colors.colorOnSurfaceVariant,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .clickable {
                    if (selectedId.invoke() == id) changeMovieGenres(EMPTY_ID)
                    else changeMovieGenres(id)
                }
                .padding(
                    vertical = dp8,
                    horizontal = dp20
                )
        )
    }
}