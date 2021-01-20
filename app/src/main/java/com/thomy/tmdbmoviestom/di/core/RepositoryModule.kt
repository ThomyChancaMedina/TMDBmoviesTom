package com.thomy.tmdbmoviestom.di.core


import com.example.data.MoviesRepository
import com.example.data.source.MovieCacheDataSource
import com.example.data.source.MovieLocalDataSource
import com.example.data.source.MovieRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieLocalDataModule: MovieLocalDataSource,
        movieRemoteDataModule: MovieRemoteDataSource,
        movieCacheDataModule: MovieCacheDataSource,
        @Named("apiKey") apiKey: String
    ): com.example.data.MovieRepositoryImpl =
        MoviesRepository(movieLocalDataModule, movieRemoteDataModule, movieCacheDataModule, apiKey)

}