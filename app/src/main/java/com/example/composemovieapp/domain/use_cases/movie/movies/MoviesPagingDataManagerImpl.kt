package com.example.composemovieapp.domain.use_cases.movie.movies

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.map
import com.example.composemovieapp.data.cloud.data_source.movie.MovieDataSource
import com.example.composemovieapp.data.model.movie.MovieData
import com.example.composemovieapp.data.paging_source.movie.MoviesPagingSource
import com.example.composemovieapp.domain.base.Mapper
import com.example.composemovieapp.domain.model.movie.MovieDomain
import com.example.composemovieapp.domain.model.movie.MoviePagingType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MoviesPagingDataManagerImpl @Inject constructor(
    private val source: MovieDataSource,
    private val mapperToMovieDomain: Mapper<MovieData, MovieDomain>
) : MoviesPagingDataManager {

    override fun fetchAllMoviesPagingData(
        moviePagingType: MoviePagingType
    ): Flow<PagingData<MovieDomain>> =
        Pager(
            config = PagingConfig(
                pageSize = MoviesPagingSource.MAX_PAGE_SIZE,
                prefetchDistance = MoviesPagingSource.PREFETCH_DISTANCE,
                enablePlaceholders = false,
                initialLoadSize = MoviesPagingSource.INITIAL_PAGE_SIZE,
                maxSize = PagingConfig.MAX_SIZE_UNBOUNDED,
                jumpThreshold = PagingSource.LoadResult.Page.COUNT_UNDEFINED
            ),
            pagingSourceFactory = {
                MoviesPagingSource(
                    moviesPagingDataSource = source,
                    dataSourceType = moviePagingType
                )
            }
        ).flow.map {
            it.map { movie ->
                mapperToMovieDomain.map(movie)
            }
        }

}