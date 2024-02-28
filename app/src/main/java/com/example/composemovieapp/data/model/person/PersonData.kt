package com.example.composemovieapp.data.model.person

import com.example.composemovieapp.data.model.movie.MovieData
import com.example.composemovieapp.data.util.MovieDataConstants.ADULT
import com.example.composemovieapp.data.util.MovieDataConstants.ID
import com.example.composemovieapp.data.util.MovieDataConstants.KNOWN_FOR
import com.example.composemovieapp.data.util.MovieDataConstants.NAME
import com.example.composemovieapp.data.util.MovieDataConstants.POPULARITY
import com.example.composemovieapp.data.util.MovieDataConstants.PROFILE_PATH
import com.google.gson.annotations.SerializedName

data class PersonData(
    @SerializedName(PROFILE_PATH) val profilePath: String?,
    @SerializedName(ADULT) val adult: Boolean,
    @SerializedName(ID) val id: Int,
    @SerializedName(KNOWN_FOR) val knownFor: List<MovieData>,
    @SerializedName(NAME) val name: String,
    @SerializedName(POPULARITY) val popularity: Double
)