package com.example.composemovieapp.di

import com.example.composemovieapp.domain.use_cases.movie.details.MovieDetailsUseCase
import com.example.composemovieapp.domain.use_cases.movie.details.MovieDetailsUseCaseImpl
import com.example.composemovieapp.domain.use_cases.movie.genres.MovieGenresUseCase
import com.example.composemovieapp.domain.use_cases.movie.genres.MovieGenresUseCaseImpl
import com.example.composemovieapp.domain.use_cases.movie.movies.MoviesPagingDataManager
import com.example.composemovieapp.domain.use_cases.movie.movies.MoviesPagingDataManagerImpl
import com.example.composemovieapp.domain.use_cases.movie.recommend.MovieRecommendUseCase
import com.example.composemovieapp.domain.use_cases.movie.recommend.MovieRecommendUseCaseImpl
import com.example.composemovieapp.domain.use_cases.movie.similar.MovieSimilarUseCase
import com.example.composemovieapp.domain.use_cases.movie.similar.MovieSimilarUseCaseImpl
import com.example.composemovieapp.domain.use_cases.person.PeoplePagingDataManager
import com.example.composemovieapp.domain.use_cases.person.PeoplePagingDataManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun provideMoviesPagingDataManager(
        impl: MoviesPagingDataManagerImpl
    ): MoviesPagingDataManager

    @Binds
    fun providePeoplePagingDataManager(
        impl: PeoplePagingDataManagerImpl
    ): PeoplePagingDataManager

    @Binds
    fun provideMovieGenresUseCase(
        impl: MovieGenresUseCaseImpl
    ): MovieGenresUseCase

    @Binds
    fun provideMovieDetailsUseCase(
        impl: MovieDetailsUseCaseImpl
    ): MovieDetailsUseCase

    @Binds
    fun provideMovieSimilarUseCase(
        impl: MovieSimilarUseCaseImpl
    ): MovieSimilarUseCase

    @Binds
    fun provideMovieRecommendUseCase(
        impl: MovieRecommendUseCaseImpl
    ): MovieRecommendUseCase

}