package com.example.composemovieapp.data.paging_source.person

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.composemovieapp.data.cloud.data_source.people.PeopleDataSource
import com.example.composemovieapp.data.model.person.PersonData

class PersonPagingSource(
    private val peoplePagingDataSource: PeopleDataSource,
) : PagingSource<Int, PersonData>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PersonData> {
        val page: Int = params.key ?: DEFAULT_PAGE
        val pageSize: Int = params.loadSize.coerceAtMost(MAX_PAGE_SIZE)
        val peoplesResponse = peoplePagingDataSource.fetchAllPersons(page = page)

        return peoplesResponse.data?.let { response ->
            val movie = response.peoples
            val nextKey = if (movie.size < pageSize) null else page + DEFAULT_PAGE
            val prevKey = if (page == DEFAULT_PAGE) null else page - DEFAULT_PAGE
            LoadResult.Page(data = movie, prevKey = prevKey, nextKey = nextKey)
        } ?: run {
            peoplesResponse.errorThrowable?.let { throwable ->
                LoadResult.Error(throwable)
            } ?: LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PersonData>): Int? {
        return state.anchorPosition
    }

    companion object {
        const val MAX_PAGE_SIZE = 20
        private const val DEFAULT_PAGE = 1
        const val INITIAL_PAGE_SIZE = MAX_PAGE_SIZE
        const val PREFETCH_DISTANCE = MAX_PAGE_SIZE / 3
    }
}


