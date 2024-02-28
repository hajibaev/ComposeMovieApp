package com.example.composemovieapp.di

import android.content.Context
import com.example.composemovieapp.data.cloud.service.MovieDetailsService
import com.example.composemovieapp.data.cloud.service.MovieService
import com.example.composemovieapp.data.cloud.service.PeopleService
import com.example.composemovieapp.presentation.util.interceptors.NetworkInterceptor
import com.example.composemovieapp.presentation.util.interceptors.network_helpers.LiveNetworkMonitor
import com.example.composemovieapp.presentation.util.interceptors.network_helpers.NetworkMonitor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

const val API_KEY = "3249dba9ba8a81c53f42a124fe89e8e5"
const val CONNECT_TIMEOUT_SECONDS = 10L
private const val BASE_URL = "https://api.themoviedb.org/3/"

@Module
@InstallIn(SingletonComponent::class)
data object ProvideModule {

    @Singleton
    @Provides
    fun provideNetworkMonitor(
        context: Context
    ): NetworkMonitor = LiveNetworkMonitor(
        context = context
    )

    @Provides
    @Singleton
    fun provideNetworkInterceptor(
        networkMonitor: NetworkMonitor
    ): NetworkInterceptor = NetworkInterceptor(
        networkMonitor = networkMonitor
    )

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        networkInterceptor: NetworkInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .readTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .writeTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(networkInterceptor)
        .build()


    @Provides
    @Singleton
    fun postRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    fun provideMovieService(retrofit: Retrofit): MovieService =
        retrofit.create(MovieService::class.java)

    @Provides
    @Singleton
    fun providePeopleService(retrofit: Retrofit): PeopleService =
        retrofit.create(PeopleService::class.java)

    @Provides
    @Singleton
    fun provideMovieDetailsService(retrofit: Retrofit): MovieDetailsService =
        retrofit.create(MovieDetailsService::class.java)

}