package com.example.composemovieapp.data.paging_source.movie

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.composemovieapp.data.cloud.data_source.movie.MovieDataSource
import com.example.composemovieapp.data.model.movie.MovieData
import com.example.composemovieapp.domain.model.movie.MoviePagingType

class MoviesPagingSource(
    private val moviesPagingDataSource: MovieDataSource,
    private val dataSourceType: MoviePagingType,
) : PagingSource<Int, MovieData>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieData> {
        val page: Int = params.key ?: DEFAULT_PAGE
        val pageSize: Int = params.loadSize.coerceAtMost(MAX_PAGE_SIZE)
        val moviesResponse = when (dataSourceType) {
            MoviePagingType.POPULAR -> moviesPagingDataSource.fetchAllPopular(
                page = page,
            )

            MoviePagingType.NOW_PLAYING -> moviesPagingDataSource.fetchAllNowPlaying(
                page = page,
            )

            MoviePagingType.TOP_RATED -> moviesPagingDataSource.fetchAllTopRated(
                page = page,
            )

            MoviePagingType.UPCOMING -> moviesPagingDataSource.fetchAllUpcoming(
                page = page,
            )

            MoviePagingType.TRENDING -> moviesPagingDataSource.fetchAllTrending(
                page = page,
            )
        }

        return moviesResponse.data?.let { response ->
            val movie = response.movies
            val nextKey = if (movie.size < pageSize) null else page + DEFAULT_PAGE
            val prevKey = if (page == DEFAULT_PAGE) null else page - DEFAULT_PAGE
            LoadResult.Page(data = movie, prevKey = prevKey, nextKey = nextKey)
        } ?: run {
            moviesResponse.errorThrowable?.let { throwable ->
                LoadResult.Error(throwable)
            } ?: LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MovieData>): Int? {
        return state.anchorPosition
    }

    companion object {
        const val MAX_PAGE_SIZE = 20
        private const val DEFAULT_PAGE = 1
        const val INITIAL_PAGE_SIZE = MAX_PAGE_SIZE
        const val PREFETCH_DISTANCE = MAX_PAGE_SIZE / 3
    }
}

