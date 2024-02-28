package com.example.composemovieapp.domain.use_cases.person

import androidx.paging.PagingData
import com.example.composemovieapp.domain.model.people.PeopleDomain
import kotlinx.coroutines.flow.Flow

interface PeoplePagingDataManager {

    fun fetchAllPeoplesPagingData(): Flow<PagingData<PeopleDomain>>

}