package com.example.composemovieapp.presentation.ui.components.items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.composemovieapp.presentation.ui.components.CustomCircularProgressView
import com.example.composemovieapp.presentation.ui.components.LoadedPoster
import com.example.composemovieapp.presentation.ui.core.colors.LocalThemeIsDark
import com.example.composemovieapp.presentation.ui.core.colors.MovieTheme
import com.example.composemovieapp.presentation.util.extensions.formatReleaseDate
import com.example.composemovieapp.presentation.util.fonts.dp1
import com.example.composemovieapp.presentation.util.fonts.dp12
import com.example.composemovieapp.presentation.util.fonts.dp14
import com.example.composemovieapp.presentation.util.fonts.dp180
import com.example.composemovieapp.presentation.util.fonts.dp230
import com.example.composemovieapp.presentation.util.fonts.dp250
import com.example.composemovieapp.presentation.util.fonts.dp6

@Composable
fun MovieItem(
    movieId: Int,
    poster: String,
    title: String,
    date: String,
    popularity: Double,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val isDarkTheme = LocalThemeIsDark.current
    Card(
        modifier = modifier
            .width(dp180)
            .clip(RoundedCornerShape(dp12))
            .padding(dp6),
        border = BorderStroke(
            width = dp1,
            color = MovieTheme.colors.colorOutline,
        ),
        colors = CardDefaults.cardColors(
            containerColor = MovieTheme.colors.colorSurfaceContainerLow
        )
    ) {
        Column(modifier = Modifier.clickable { onClick.invoke(movieId) }) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dp250)
            ) {
                LoadedPoster(
                    url = poster,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dp230)
                        .clip(RoundedCornerShape(topStart = dp12, topEnd = dp12)),
                )
                CustomCircularProgressView(
                    popularity = { popularity },
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(horizontal = dp12)
                )
            }
            Column {
                Spacer(modifier = Modifier.height(dp6))
                Text(
                    text = title,
                    style = MovieTheme.typography.titleMedium,
                    color = if (isDarkTheme.value) Color.White else Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(horizontal = dp12)
                )

                Spacer(modifier = Modifier.height(dp6))

                Text(
                    text = formatReleaseDate(date),
                    color = MovieTheme.colors.colorOutline,
                    style = MovieTheme.typography.titleSmall,
                    modifier = Modifier.padding(horizontal = dp12)
                )
                Spacer(modifier = Modifier.height(dp14))
            }
        }
    }
}


@Preview
@Composable
fun MovieItemPreview() {
    MaterialTheme {
        MovieItem(
            movieId = 0,
            poster = "https://avatars.mds.yandex.net/get-kinopoisk-image/10835644/b3e7ecff-78e9-428b-b5a2-a945675c3e11/600x900",
            title = "Movie",
            popularity = 7.1,
            date = "10 yan 2024",
            onClick = {},
        )
    }
}