package com.example.composemovieapp.data.cloud.data_source.people

import com.example.composemovieapp.data.base.BaseDataSource
import com.example.composemovieapp.data.cloud.service.PeopleService
import com.example.composemovieapp.data.model.person.PersonResponseData
import com.example.composemovieapp.domain.base.ResultModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Locale
import javax.inject.Inject

class PeopleDataSourceImpl @Inject constructor(
    private val service: PeopleService,
) : BaseDataSource(), PeopleDataSource {

    private val locale = Locale.getDefault().language

    override suspend fun fetchAllPersons(
        page: Int,
    ): ResultModel<PersonResponseData> = withContext(Dispatchers.IO) {
        invokeRequest {
            service.fetchAllPeoples(
                language = locale,
                page = page,
            )
        }
    }

}