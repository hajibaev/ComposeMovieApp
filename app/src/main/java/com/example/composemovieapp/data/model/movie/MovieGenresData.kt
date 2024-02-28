package com.example.composemovieapp.data.model.movie

import com.example.composemovieapp.data.util.MovieDataConstants.ID
import com.example.composemovieapp.data.util.MovieDataConstants.NAME
import com.google.gson.annotations.SerializedName

data class MovieGenresData(
    @SerializedName(ID) val id: Int,
    @SerializedName(NAME) val name: String
)