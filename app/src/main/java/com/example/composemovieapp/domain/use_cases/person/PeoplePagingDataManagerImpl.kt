package com.example.composemovieapp.domain.use_cases.person

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.map
import com.example.composemovieapp.data.cloud.data_source.people.PeopleDataSource
import com.example.composemovieapp.data.model.person.PersonData
import com.example.composemovieapp.data.paging_source.person.PersonPagingSource
import com.example.composemovieapp.domain.base.Mapper
import com.example.composemovieapp.domain.model.people.PeopleDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PeoplePagingDataManagerImpl @Inject constructor(
    private val source: PeopleDataSource,
    private val mapperToPeopleDomain: Mapper<PersonData, PeopleDomain>
) : PeoplePagingDataManager {

    override fun fetchAllPeoplesPagingData(): Flow<PagingData<PeopleDomain>> =
        Pager(
            config = PagingConfig(
                pageSize = PersonPagingSource.MAX_PAGE_SIZE,
                prefetchDistance = PersonPagingSource.PREFETCH_DISTANCE,
                enablePlaceholders = false,
                initialLoadSize = PersonPagingSource.INITIAL_PAGE_SIZE,
                maxSize = PagingConfig.MAX_SIZE_UNBOUNDED,
                jumpThreshold = PagingSource.LoadResult.Page.COUNT_UNDEFINED
            ),
            pagingSourceFactory = {
                PersonPagingSource(
                    peoplePagingDataSource = source,
                )
            }
        ).flow.map {
            it.map { movie ->
                mapperToPeopleDomain.map(movie)
            }
        }

}