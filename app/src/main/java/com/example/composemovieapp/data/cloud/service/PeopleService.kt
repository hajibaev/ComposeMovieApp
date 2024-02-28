package com.example.composemovieapp.data.cloud.service

import com.example.composemovieapp.data.model.person.PersonResponseData
import com.example.composemovieapp.data.util.MovieDataConstants.APIKEY
import com.example.composemovieapp.data.util.MovieDataConstants.LANGUAGE
import com.example.composemovieapp.data.util.MovieDataConstants.PAGE
import com.example.composemovieapp.data.util.MovieDataConstants.PEOPLE
import com.example.composemovieapp.di.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PeopleService {

    @GET(PEOPLE)
    suspend fun fetchAllPeoples(
        @Query(APIKEY) apiKey: String = API_KEY,
        @Query(LANGUAGE) language: String,
        @Query(PAGE) page: Int,
    ): Response<PersonResponseData>

}