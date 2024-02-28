package com.example.composemovieapp.data.model.movie

import com.example.composemovieapp.data.util.MovieDataConstants.GENRES
import com.google.gson.annotations.SerializedName


data class MovieGenresResponseData(
    @SerializedName(GENRES) val genres: List<MovieGenresData>
)