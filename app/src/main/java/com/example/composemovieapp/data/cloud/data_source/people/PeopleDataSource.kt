package com.example.composemovieapp.data.cloud.data_source.people

import com.example.composemovieapp.data.model.person.PersonResponseData
import com.example.composemovieapp.domain.base.ResultModel

interface PeopleDataSource {

    suspend fun fetchAllPersons(
        page: Int,
    ): ResultModel<PersonResponseData>

}