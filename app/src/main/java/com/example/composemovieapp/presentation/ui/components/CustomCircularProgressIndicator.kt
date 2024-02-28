package com.example.composemovieapp.presentation.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.composemovieapp.presentation.ui.core.colors.DarkBlue
import com.example.composemovieapp.presentation.ui.core.colors.GreenBold
import com.example.composemovieapp.presentation.ui.core.colors.GreenTrack
import com.example.composemovieapp.presentation.ui.core.colors.RedBold
import com.example.composemovieapp.presentation.ui.core.colors.RedTrack
import com.example.composemovieapp.presentation.ui.core.colors.YellowBold
import com.example.composemovieapp.presentation.ui.core.colors.YellowTrackBold
import com.example.composemovieapp.presentation.util.fonts.dp2
import com.example.composemovieapp.presentation.util.fonts.dp4
import com.example.composemovieapp.presentation.util.fonts.dp50
import com.example.composemovieapp.presentation.util.fonts.interRegular
import com.example.composemovieapp.presentation.util.fonts.labelMediumFontSize

@Composable
fun CustomCircularProgressView(
    popularity: () -> Double,
    modifier: Modifier = Modifier,
) {

    val voteAverage = (popularity() * 10.0).toInt()

    val progressColor = when {
        voteAverage >= 70 -> GreenBold
        voteAverage in 41..69 -> YellowBold
        else -> RedBold
    }

    val totalColor = when {
        voteAverage >= 70 -> GreenTrack
        voteAverage in 41..69 -> YellowTrackBold
        else -> RedTrack
    }
    Card(
        modifier = modifier
            .clip(CircleShape),
        colors = CardDefaults.cardColors(
            containerColor = DarkBlue,
        )
    ) {
        Box(
            modifier = Modifier
                .size(dp50)
                .padding(dp4),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                progress = voteAverage / 100f,
                progressColor = progressColor,
                totalColor = totalColor,
            )

            Box(
                contentAlignment = Alignment.Center
            ) {
                val progressText = if (voteAverage >= 100) "100" else voteAverage
                Text(
                    text = "${progressText}%",
                    fontSize = labelMediumFontSize,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = interRegular,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun CircularProgressIndicator(
    modifier: Modifier = Modifier,
    progress: Float,
    progressColor: Color,
    totalColor: Color
) {
    val progressAngle = progress * 360

    Canvas(
        modifier = modifier.size(dp50)
    ) {

        drawArc(
            color = progressColor,
            startAngle = -90f,
            sweepAngle = progressAngle,
            useCenter = false,
            style = Stroke(width = dp2.toPx())
        )

        if (progress < 1f) {
            drawArc(
                color = totalColor,
                startAngle = -90f + progressAngle,
                sweepAngle = (1f - progress) * 360,
                useCenter = false,
                style = Stroke(width = dp2.toPx())
            )
        }
    }
}

@Preview
@Composable
fun CircularProgressBarPreview() {
    Surface {
        CustomCircularProgressView(popularity = {
            7.5
        })
    }
}
