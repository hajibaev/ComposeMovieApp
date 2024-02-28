package com.example.composemovieapp.presentation.ui.screens.actors

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import com.example.composemovieapp.R
import com.example.composemovieapp.presentation.model.people.PeopleUiModel
import com.example.composemovieapp.presentation.ui.components.items.PeopleItem
import com.example.composemovieapp.presentation.ui.core.colors.MovieTheme
import com.example.composemovieapp.presentation.ui.core.ui_components.LoadingScreen
import com.example.composemovieapp.presentation.ui.core.ui_components.ShowError
import com.example.composemovieapp.presentation.util.fonts.dp22

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActorsScreen(
    peoples: LazyPagingItems<PeopleUiModel>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        CenterAlignedTopAppBar(
            modifier = Modifier.clickable { },
            title = {
                Text(
                    text = stringResource(id = R.string.bottom_actors_title),
                    style = MovieTheme.typography.titleLarge,
                    color = MovieTheme.colors.colorOnSurface,
                    fontWeight = FontWeight.Bold,
                )
            }
        )
        if (peoples.loadState.refresh == LoadState.NotLoading(false) ||
            peoples.loadState.append == LoadState.NotLoading(false)
        ) ActorsList(peoples = peoples)
        else CheckPeoplePagingState(peoples = peoples)
    }
}


@Composable
fun CheckPeoplePagingState(
    peoples: LazyPagingItems<PeopleUiModel>,
) {
    peoples.loadState.apply {
        when {
            refresh is LoadState.Loading -> LoadingScreen()
            refresh is LoadState.Error || append is LoadState.Error -> {
                val errorState = refresh as? LoadState.Error ?: append as? LoadState.Error
                ShowError(
                    throwable = errorState?.error
                        ?: Throwable(stringResource(id = R.string.error_unknown)),
                    onConfirmation = { peoples.retry() }
                )
            }
        }
    }
}


@Composable
fun ActorsList(
    peoples: LazyPagingItems<PeopleUiModel>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(
            count = peoples.itemCount,
            key = peoples.itemKey { people -> people.randomId }
        ) { index ->
            peoples[index]?.let {
                val movieNames = it.knownFor
                    .map { actorsFilms -> actorsFilms.title.trim() }
                    .filter { actorsFilms -> actorsFilms.isNotBlank() }
                    .joinToString(", ")

                PeopleItem(
                    poster = it.profilePath,
                    name = it.name,
                    movieNames = movieNames
                )
            }
        }
        if (peoples.loadState.append == LoadState.Loading) item {
            LoadingScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = dp22)
                    .background(MaterialTheme.colorScheme.background)
                    .then(modifier),
            )
        }
    }
}