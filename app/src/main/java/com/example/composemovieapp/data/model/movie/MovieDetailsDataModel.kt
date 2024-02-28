package com.example.composemovieapp.data.model.movie

import com.example.composemovieapp.data.util.MovieDataConstants.ADULT
import com.example.composemovieapp.data.util.MovieDataConstants.BACKDROP_PATH
import com.example.composemovieapp.data.util.MovieDataConstants.BUDGET
import com.example.composemovieapp.data.util.MovieDataConstants.GENRES
import com.example.composemovieapp.data.util.MovieDataConstants.ID
import com.example.composemovieapp.data.util.MovieDataConstants.OR_LANGUAGE
import com.example.composemovieapp.data.util.MovieDataConstants.OR_TITLE
import com.example.composemovieapp.data.util.MovieDataConstants.OVERVIEW
import com.example.composemovieapp.data.util.MovieDataConstants.POPULARITY
import com.example.composemovieapp.data.util.MovieDataConstants.POSTER
import com.example.composemovieapp.data.util.MovieDataConstants.RELEASE_DATE
import com.example.composemovieapp.data.util.MovieDataConstants.VOTE_AVERAGE
import com.example.composemovieapp.data.util.MovieDataConstants.VOTE_COUNT
import com.google.gson.annotations.SerializedName

data class MovieDetailsDataModel(
    @SerializedName(ADULT) val adult: Boolean,
    @SerializedName(BACKDROP_PATH) val backdropPath: String?,
    @SerializedName(BUDGET) val budget: Int,
    @SerializedName(GENRES) val genres: List<MovieGenresData>?,
    @SerializedName(ID) val id: Int,
    @SerializedName(OR_LANGUAGE) val language: String,
    @SerializedName(OR_TITLE) val title: String,
    @SerializedName(OVERVIEW) val overview: String,
    @SerializedName(POPULARITY) val popularity: Double,
    @SerializedName(POSTER) val posterPath: String?,
    @SerializedName(RELEASE_DATE) val releaseDate: String,
    @SerializedName(VOTE_AVERAGE) val voteAverage: Double,
    @SerializedName(VOTE_COUNT) val voteCount: Int
)