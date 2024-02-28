package com.example.composemovieapp.di

import com.example.composemovieapp.data.cloud.data_source.movie.MovieDataSource
import com.example.composemovieapp.data.cloud.data_source.movie.MovieDataSourceImpl
import com.example.composemovieapp.data.cloud.data_source.movie_details.MovieDetailsDataSource
import com.example.composemovieapp.data.cloud.data_source.movie_details.MovieDetailsDataSourceImpl
import com.example.composemovieapp.data.cloud.data_source.people.PeopleDataSource
import com.example.composemovieapp.data.cloud.data_source.people.PeopleDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun provideMovieDataSource(
        impl: MovieDataSourceImpl
    ): MovieDataSource

    @Binds
    fun provideMovieDetailsDataSource(
        impl: MovieDetailsDataSourceImpl
    ): MovieDetailsDataSource

    @Binds
    fun providePeopleDataSource(
        impl: PeopleDataSourceImpl
    ): PeopleDataSource

}