package com.example.composemovieapp.di

import com.example.composemovieapp.data.mappers.MapFromGenresDataToDomain
import com.example.composemovieapp.data.mappers.MapFromMovieDataToDomain
import com.example.composemovieapp.data.mappers.MapFromMovieDetailsDataToDomain
import com.example.composemovieapp.data.mappers.MapFromPeopleDataToDomain
import com.example.composemovieapp.data.model.movie.MovieData
import com.example.composemovieapp.data.model.movie.MovieDetailsDataModel
import com.example.composemovieapp.data.model.movie.MovieGenresData
import com.example.composemovieapp.data.model.person.PersonData
import com.example.composemovieapp.domain.base.Mapper
import com.example.composemovieapp.domain.model.movie.MovieDetailsDomainModel
import com.example.composemovieapp.domain.model.movie.MovieDomain
import com.example.composemovieapp.domain.model.movie.MovieGenresDomain
import com.example.composemovieapp.domain.model.people.PeopleDomain
import com.example.composemovieapp.presentation.mappers.MapFromMovieDetailsDomainToUi
import com.example.composemovieapp.presentation.mappers.MapFromMovieDomainToUi
import com.example.composemovieapp.presentation.mappers.MapFromMovieGenresDomainToUi
import com.example.composemovieapp.presentation.mappers.MapFromPeopleDomainToUi
import com.example.composemovieapp.presentation.model.movie.MovieDetailsUiModel
import com.example.composemovieapp.presentation.model.movie.MovieGenresUiModel
import com.example.composemovieapp.presentation.model.movie.MovieUiModel
import com.example.composemovieapp.presentation.model.people.PeopleUiModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MappersModule {

    @Binds
    fun bindMapperToMovieDomain(
        impl: MapFromMovieDataToDomain
    ): Mapper<MovieData, MovieDomain>

    @Binds
    fun bindMapFromMovieDomainToUi(
        impl: MapFromMovieDomainToUi
    ): Mapper<MovieDomain, MovieUiModel>

    @Binds
    fun bindMapFromGenresDataToDomain(
        impl: MapFromGenresDataToDomain
    ): Mapper<MovieGenresData, MovieGenresDomain>

    @Binds
    fun bindMapFromMovieGenresDomainToUi(
        impl: MapFromMovieGenresDomainToUi
    ): Mapper<MovieGenresDomain, MovieGenresUiModel>

    @Binds
    fun bindMapFromMovieDetailsDataToDomain(
        impl: MapFromMovieDetailsDataToDomain
    ): Mapper<MovieDetailsDataModel, MovieDetailsDomainModel>

    @Binds
    fun bindMapFromMovieDetailsDomainToUi(
        impl: MapFromMovieDetailsDomainToUi
    ): Mapper<MovieDetailsDomainModel, MovieDetailsUiModel>

    @Binds
    fun bindMapFromPeopleDataToDomain(
        impl: MapFromPeopleDataToDomain
    ): Mapper<PersonData, PeopleDomain>

    @Binds
    fun bindMapFromPeopleDomainToUi(
        impl: MapFromPeopleDomainToUi
    ): Mapper<PeopleDomain, PeopleUiModel>

}