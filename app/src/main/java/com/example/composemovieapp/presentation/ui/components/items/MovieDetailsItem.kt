package com.example.composemovieapp.presentation.ui.components.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.composemovieapp.presentation.ui.components.CustomCircularProgressView
import com.example.composemovieapp.presentation.ui.components.LoadedPoster
import com.example.composemovieapp.presentation.ui.core.colors.MovieTheme
import com.example.composemovieapp.presentation.util.fonts.dp10
import com.example.composemovieapp.presentation.util.fonts.dp3
import com.example.composemovieapp.presentation.util.fonts.dp4

@Composable
fun MovieDetailsItem(
    id: Int,
    poster: String,
    popularity: Double,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(dp10))
            .padding(dp4),
        colors = CardDefaults.cardColors(
            containerColor = MovieTheme.colors.colorSurface
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClick.invoke(id) }
        ) {
            LoadedPoster(
                url = poster,
                modifier = Modifier.fillMaxSize()
            )
            CustomCircularProgressView(
                popularity = { popularity },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(dp3)
            )
        }
    }
}