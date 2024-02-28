package com.example.composemovieapp.presentation.ui.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.example.composemovieapp.R
import com.example.composemovieapp.presentation.model.movie.MovieGenresUiModel
import com.example.composemovieapp.presentation.model.movie.MovieUiModel
import com.example.composemovieapp.presentation.ui.components.items.AppearanceBottomSheet
import com.example.composemovieapp.presentation.ui.components.items.CategoryItem
import com.example.composemovieapp.presentation.ui.components.items.MovieItem
import com.example.composemovieapp.presentation.ui.components.items.MovieTypeBottomSheet
import com.example.composemovieapp.presentation.ui.core.colors.MovieTheme
import com.example.composemovieapp.presentation.ui.core.ui_components.LoadingScreen
import com.example.composemovieapp.presentation.ui.core.ui_components.ShowError
import com.example.composemovieapp.presentation.ui.screens.home.model.MovieEvent
import com.example.composemovieapp.presentation.ui.screens.home.model.MovieUiState
import com.example.composemovieapp.presentation.util.extensions.toTitle
import com.example.composemovieapp.presentation.util.fonts.dp10
import com.example.composemovieapp.presentation.util.fonts.dp12
import com.example.composemovieapp.presentation.util.fonts.dp6
import compose.icons.FeatherIcons
import compose.icons.feathericons.Menu
import kotlinx.coroutines.flow.StateFlow

@Composable
fun MainScreen(
    uiState: StateFlow<MovieUiState>,
    navigateToDetailsScreen: (Int) -> Unit,
    onEvent: (MovieEvent) -> Unit,
) {
    LaunchedEffect(key1 = true) {
        onEvent(MovieEvent.OnGenAllMovieGenres)
    }

    when (val state = uiState.collectAsState().value) {
        is MovieUiState.Loading -> LoadingScreen()

        is MovieUiState.Error -> ShowError(
            throwable = state.throwable,
            onConfirmation = { onEvent(state.callbackRetry) }
        )

        is MovieUiState.Loaded -> {
            LoadedMovies(
                uiState = state,
                onEvent = onEvent,
                navigateToDetailsScreen = navigateToDetailsScreen
            )
        }

        is MovieUiState.MoviePaging -> {
            MoviePaging(
                uiState = state,
                onEvent = onEvent,
                navigateToDetailsScreen = navigateToDetailsScreen,
            )
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MoviePaging(
    uiState: MovieUiState.MoviePaging,
    onEvent: (MovieEvent) -> Unit,
    navigateToDetailsScreen: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = uiState.refreshing,
        onRefresh = { onEvent(MovieEvent.OnLoadNextMovies(true)) })

    Box(
        modifier = modifier
            .fillMaxSize()
            .pullRefresh(state = pullRefreshState)
    ) {
        LazyVerticalStaggeredGrid(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = dp6),
            columns = StaggeredGridCells.Fixed(2),
        ) {
            itemsIndexed(
                uiState.movies,
                key = { _, movie -> movie.hashCode() }
            ) { index, movie ->
                MovieItem(
                    movieId = movie.movieId,
                    poster = movie.poster,
                    title = movie.title,
                    date = movie.date,
                    popularity = movie.popularity,
                    onClick = navigateToDetailsScreen
                )

                if (index >= uiState.movies.size - 1 && !uiState.loading && !uiState.loadFinished) {
                    onEvent(MovieEvent.OnLoadNextMovies(false))
                }
            }
        }

        PullRefreshIndicator(
            refreshing = uiState.refreshing,
            state = pullRefreshState,
            modifier = modifier.align(Alignment.TopCenter)
        )
    }
}

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoadedMovies(
    uiState: MovieUiState.Loaded,
    onEvent: (MovieEvent) -> Unit,
    navigateToDetailsScreen: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    var movieTypeBottomSheetState by remember { mutableStateOf(false) }
    var settingsBottomSheetState by remember { mutableStateOf(false) }
    val moviesPaging = uiState.movies.collectAsLazyPagingItems()
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MovieTheme.colors.colorSurface,
                ),
                title = {
                    Text(
                        text = stringResource(id = uiState.selectedMovieType.toTitle()),
                        style = MovieTheme.typography.titleLarge,
                        color = MovieTheme.colors.colorOnSurface,
                        fontWeight = FontWeight.Bold,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { movieTypeBottomSheetState = true }) {
                        Icon(
                            imageVector = FeatherIcons.Menu,
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { settingsBottomSheetState = true }) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = null
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            CategoryList(
                category = uiState.genres,
                selectedGenresId = uiState.selectedGenresId,
                changeMovieGenres = { onEvent(MovieEvent.OnChangeMovieGenres(it)) },
            )
            if (moviesPaging.loadState.refresh == LoadState.NotLoading(false) ||
                moviesPaging.loadState.append == LoadState.NotLoading(false)
            ) {
                MovieList(
                    moviesPaging = moviesPaging,
                    navigateToDetailsScreen = navigateToDetailsScreen
                )
            } else CheckMoviePagingState(moviesPaging = moviesPaging)
        }

        if (movieTypeBottomSheetState) MovieTypeBottomSheet(
            changeMovieType = { onEvent(MovieEvent.OnChangeMovieType(it)) },
            selectedItem = { uiState.selectedMovieType },
            dialogState = { movieTypeBottomSheetState = it }
        )
        else if (settingsBottomSheetState) AppearanceBottomSheet(
            dialogState = { settingsBottomSheetState = it }
        )
    }
}


@Composable
fun CheckMoviePagingState(
    moviesPaging: LazyPagingItems<MovieUiModel>,
) {
    moviesPaging.loadState.apply {
        when {
            refresh is LoadState.Loading -> LoadingScreen()
            refresh is LoadState.Error || append is LoadState.Error -> {
                val errorState = refresh as? LoadState.Error ?: append as? LoadState.Error
                ShowError(
                    throwable = errorState?.error
                        ?: Throwable(stringResource(id = R.string.error_unknown)),
                    onConfirmation = { moviesPaging.retry() }
                )
            }
        }
    }
}

@Composable
fun CategoryList(
    category: List<MovieGenresUiModel>,
    selectedGenresId: Int,
    changeMovieGenres: (Int) -> Unit
) {
    LazyRow(
        modifier = Modifier.padding(
            start = dp10,
            end = dp10,
            top = dp12,
            bottom = dp10
        )
    ) {
        items(
            items = category,
            key = { item -> item.id }
        ) { category ->
            CategoryItem(
                id = category.id,
                title = category.name,
                selectedId = { selectedGenresId },
                changeMovieGenres = { changeMovieGenres.invoke(it) }
            )
        }
    }
}

@Composable
fun MovieList(
    moviesPaging: LazyPagingItems<MovieUiModel>,
    navigateToDetailsScreen: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalStaggeredGrid(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = dp6),
        columns = StaggeredGridCells.Fixed(2),
    ) {

        items(
            count = moviesPaging.itemCount,
            key = moviesPaging.itemKey { movie -> movie.hashCode() },
        ) { index ->
            moviesPaging[index]?.let {
                Log.i("Umar", "poster = ${it.poster}")
                MovieItem(
                    movieId = it.movieId,
                    poster = it.poster,
                    title = it.title,
                    date = it.date,
                    popularity = it.popularity,
                    onClick = navigateToDetailsScreen
                )
            }
        }
        if (moviesPaging.loadState.append == LoadState.Loading) item { LoadingScreen() }
    }
}