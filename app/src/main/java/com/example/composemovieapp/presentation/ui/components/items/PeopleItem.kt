package com.example.composemovieapp.presentation.ui.components.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import com.example.composemovieapp.presentation.ui.components.LoadedPoster
import com.example.composemovieapp.presentation.ui.core.colors.MovieTheme
import com.example.composemovieapp.presentation.util.fonts.dp10
import com.example.composemovieapp.presentation.util.fonts.dp16
import com.example.composemovieapp.presentation.util.fonts.dp5
import com.example.composemovieapp.presentation.util.fonts.dp6
import com.example.composemovieapp.presentation.util.fonts.dp80
import com.example.composemovieapp.presentation.util.fonts.dp92

@Composable
fun PeopleItem(
    poster: String,
    name: String,
    movieNames: String,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { },
        verticalAlignment = Alignment.CenterVertically
    ) {

        LoadedPoster(
            url = poster,
//            placeholder = R.drawable.profile_circle,
            modifier = Modifier
                .width(dp92)
                .height(dp80)
                .padding(vertical = dp10, horizontal = dp16)
                .clip(RoundedCornerShape(dp6)),
        )

        Column(
            modifier = Modifier.padding(
                vertical = dp10,
                horizontal = dp5
            )
        ) {
            Text(
                text = name,
                style = MovieTheme.typography.bodyMedium,
                color = MovieTheme.colors.colorSurfaceInverse,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = movieNames,
                color = MovieTheme.colors.colorOutline,
                style = MovieTheme.typography.titleSmall,
                maxLines = 1,
            )
        }
    }
}