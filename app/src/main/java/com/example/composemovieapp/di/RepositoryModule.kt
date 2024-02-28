package com.example.composemovieapp.di

import com.example.composemovieapp.data.repository.MovieDetailsRepositoryImpl
import com.example.composemovieapp.data.repository.MovieRepositoryImpl
import com.example.composemovieapp.domain.repository.MovieDetailsRepository
import com.example.composemovieapp.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface  RepositoryModule {

    @Binds
    fun provideMovieRepository(
        impl: MovieRepositoryImpl
    ): MovieRepository

    @Binds
    fun provideMovieDetailsRepository(
        impl: MovieDetailsRepositoryImpl
    ): MovieDetailsRepository

}