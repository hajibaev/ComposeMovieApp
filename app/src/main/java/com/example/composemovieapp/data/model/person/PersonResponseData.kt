package com.example.composemovieapp.data.model.person

import com.example.composemovieapp.data.util.MovieDataConstants.PAGE
import com.example.composemovieapp.data.util.MovieDataConstants.RESULTS
import com.example.composemovieapp.data.util.MovieDataConstants.TOTAL_PAGES
import com.example.composemovieapp.data.util.MovieDataConstants.TOTAL_RESULTS
import com.google.gson.annotations.SerializedName

data class PersonResponseData(
    @SerializedName(PAGE) val page: Int,
    @SerializedName(RESULTS) val peoples: List<PersonData>,
    @SerializedName(TOTAL_RESULTS) val totalResults: Int,
    @SerializedName(TOTAL_PAGES) val totalPages: Int,
)

