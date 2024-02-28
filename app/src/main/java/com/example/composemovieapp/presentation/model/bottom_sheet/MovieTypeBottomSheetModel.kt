package com.example.composemovieapp.presentation.model.bottom_sheet

import androidx.compose.runtime.Immutable
import com.example.composemovieapp.R
import com.example.composemovieapp.domain.model.movie.MoviePagingType
import java.util.Random

@Immutable
data class MovieTypeBottomSheetModel(
    val id: Int,
    val title: Int,
    val isSelectedType: MoviePagingType
)

fun movieBottomSheetItems(): List<MovieTypeBottomSheetModel> {
    val random = Random()
    return listOf(
        MovieTypeBottomSheetModel(
            id = random.nextInt(),
            title = R.string.movie_trending,
            isSelectedType = MoviePagingType.TRENDING
        ),
        MovieTypeBottomSheetModel(
            id = random.nextInt(),
            title = R.string.movie_popular,
            isSelectedType = MoviePagingType.POPULAR
        ),
        MovieTypeBottomSheetModel(
            id = random.nextInt(),
            title = R.string.movie_now_playing,
            isSelectedType = MoviePagingType.NOW_PLAYING
        ),
        MovieTypeBottomSheetModel(
            id = random.nextInt(),
            title = R.string.movie_top_rated,
            isSelectedType = MoviePagingType.TOP_RATED
        ),
        MovieTypeBottomSheetModel(
            id = random.nextInt(),
            title = R.string.movie_up_coming,
            isSelectedType = MoviePagingType.UPCOMING
        ),
    )
}