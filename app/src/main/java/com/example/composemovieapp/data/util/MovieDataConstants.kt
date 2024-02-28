package com.example.composemovieapp.data.util

object MovieDataConstants {

    /** url **/
    const val NOW_PLAYING = "movie/now_playing"
    const val POPULAR = "movie/popular"
    const val TOP_RATED = "movie/top_rated"
    const val UPCOMING = "movie/upcoming"
    const val TRENDING = "trending/movie/week"
    const val GENRES_GET = "genre/movie/list"
    const val MOVIE_DETAILS = "movie/{movie_id}"
    const val SIMILAR = "movie/{movie_id}/similar"
    const val RECOMMENDATIONS = "movie/{movie_id}/recommendations"
    const val PEOPLE = "person/popular"

    // Params
    const val LANGUAGE = "language"
    const val APIKEY = "api_key"

    /** response **/
    const val PAGE = "page"
    const val RESULTS = "results"
    const val TOTAL_RESULTS = "total_results"
    const val TOTAL_PAGES = "total_pages"

    /** base **/
    const val ID = "id"
    const val NAME = "name"
    const val POPULARITY = "popularity"

    /** movie **/
    const val POSTER = "poster_path"
    const val TITLE = "title"
    const val VOTE_AVERAGE = "vote_average"
    const val RELEASE_DATE = "release_date"
    const val GENRES_ID = "genre_ids"

    /** person **/
    const val PROFILE_PATH = "profile_path"
    const val KNOWN_FOR = "known_for"

    /** movies and persons **/
    const val MOVIE_ID = "movie_id"
    const val ADULT = "adult"
    const val BACKDROP_PATH = "backdrop_path"
    const val BUDGET = "budget"
    const val OR_LANGUAGE = "original_language"
    const val OR_TITLE = "original_title"
    const val OVERVIEW = "overview"
    const val VOTE_COUNT = "vote_count"

    /** genres **/
    const val GENRES = "genres"


    const val POSTER_URL = "https://image.tmdb.org/t/p/original"
    const val EMPTY_STRING = ""
    const val EMPTY_ID = 0
    const val NOT_FOUND = "not found"
}