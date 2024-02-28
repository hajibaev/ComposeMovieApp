package com.example.composemovieapp.data.model.movie

import com.example.composemovieapp.data.util.MovieDataConstants.PAGE
import com.example.composemovieapp.data.util.MovieDataConstants.RESULTS
import com.example.composemovieapp.data.util.MovieDataConstants.TOTAL_PAGES
import com.example.composemovieapp.data.util.MovieDataConstants.TOTAL_RESULTS
import com.google.gson.annotations.SerializedName

data class MoviesResponseData(
    @SerializedName(PAGE) val page: Int,
    @SerializedName(RESULTS) val movies: List<MovieData>,
    @SerializedName(TOTAL_RESULTS) val totalResults: Int,
    @SerializedName(TOTAL_PAGES) val totalPages: Int,
)
