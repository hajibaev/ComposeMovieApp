package com.example.composemovieapp.data.model.movie

import com.example.composemovieapp.data.util.MovieDataConstants.GENRES_ID
import com.example.composemovieapp.data.util.MovieDataConstants.ID
import com.example.composemovieapp.data.util.MovieDataConstants.POSTER
import com.example.composemovieapp.data.util.MovieDataConstants.RELEASE_DATE
import com.example.composemovieapp.data.util.MovieDataConstants.TITLE
import com.example.composemovieapp.data.util.MovieDataConstants.VOTE_AVERAGE
import com.google.gson.annotations.SerializedName


data class MovieData(
    @SerializedName(ID) val movieId: Int,
    @SerializedName(POSTER) val posterPath: String?,
    @SerializedName(TITLE) val title: String?,
    @SerializedName(VOTE_AVERAGE) val voteAverage: Double,
    @SerializedName(RELEASE_DATE) val releaseDate: String?,
    @SerializedName(GENRES_ID) val genreIds: List<Int>?,
)