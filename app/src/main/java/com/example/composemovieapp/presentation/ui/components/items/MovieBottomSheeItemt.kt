package com.example.composemovieapp.presentation.ui.components.items

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composemovieapp.R
import com.example.composemovieapp.domain.model.movie.MoviePagingType
import com.example.composemovieapp.presentation.model.bottom_sheet.MovieTypeBottomSheetModel
import com.example.composemovieapp.presentation.model.bottom_sheet.movieBottomSheetItems
import com.example.composemovieapp.presentation.ui.core.colors.MovieTheme
import com.example.composemovieapp.presentation.util.fonts.dp18
import com.example.composemovieapp.presentation.util.fonts.dp2
import com.example.composemovieapp.presentation.util.fonts.dp50
import com.example.composemovieapp.presentation.util.fonts.dp6
import compose.icons.FeatherIcons
import compose.icons.feathericons.Check
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieTypeBottomSheet(
    changeMovieType: (MoviePagingType) -> Unit,
    selectedItem: () -> MoviePagingType,
    dialogState: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = {
            coroutineScope.launch { modalBottomSheetState.hide() }
            dialogState.invoke(false)
        },
        sheetState = modalBottomSheetState
    ) {
        LazyColumn(modifier = modifier.padding(vertical = dp6)) {
            items(
                items = movieBottomSheetItems(),
                key = { item -> item.id }
            ) { item ->
                MovieTypeBottomSheetItem(
                    data = item,
                    selectedItem = selectedItem,
                    changeMovieType = changeMovieType,
                    dialogState = dialogState,
                )
            }
        }
    }
}


@Composable
fun MovieTypeBottomSheetItem(
    data: MovieTypeBottomSheetModel,
    changeMovieType: (MoviePagingType) -> Unit,
    selectedItem: () -> MoviePagingType,
    dialogState: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {

    Row(
        modifier
            .fillMaxWidth()
            .height(dp50)
            .clickable {
                if (selectedItem() != data.isSelectedType) {
                    changeMovieType.invoke(data.isSelectedType)
                    dialogState.invoke(false)
                }
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(horizontal = dp18),
            text = stringResource(id = data.title),
            style = MovieTheme.typography.bodyLarge,
        )
        if (selectedItem() == data.isSelectedType) {
            Icon(
                imageVector = FeatherIcons.Check,
                contentDescription = null,
                tint = MovieTheme.colors.colorPrimary,
                modifier = Modifier.padding(horizontal = dp18)
            )
        }
    }
    Divider(modifier = Modifier.padding(vertical = dp2))
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun MovieTypeItemPreview() {
    MovieTheme {
        MovieTypeBottomSheetItem(
            data = MovieTypeBottomSheetModel(
                id = 1,
                title = R.string.movie_trending,
                isSelectedType = MoviePagingType.TRENDING
            ),
            selectedItem = { MoviePagingType.TRENDING },
            changeMovieType = {},
            dialogState = { true }
        )
    }
}