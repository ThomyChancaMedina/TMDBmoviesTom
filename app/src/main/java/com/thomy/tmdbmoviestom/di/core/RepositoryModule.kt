package com.thomy.tmdbmoviestom.di.core


import com.example.data.repository.artists.ArtistRepository
import com.example.data.repository.artists.ArtistRepositoryImpl
import com.example.data.repository.movies.MovieRepository
import com.example.data.repository.movies.MoviesRepositoryImpl
import com.example.data.repository.tvshows.TvShowRepository
import com.example.data.repository.tvshows.TvShowRepositoryImpl
import com.example.data.source.RemoteDataSource
import com.example.data.source.artists.ArtistCacheDataSource
import com.example.data.source.artists.ArtistLocalDataSource
import com.example.data.source.movies.MovieCacheDataSource
import com.example.data.source.movies.MovieLocalDataSource
import com.example.data.source.tvshows.TvShowCacheDataSource
import com.example.data.source.tvshows.TvShowLocalDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providerMovieRepository(
        movieLocalDataModule: MovieLocalDataSource,
        movieRemoteDataModule: RemoteDataSource,
        movieCacheDataModule: MovieCacheDataSource,
        @Named("apiKey") apiKey: String
    ): MovieRepository =
        MoviesRepositoryImpl(
            movieLocalDataModule,
            movieRemoteDataModule,
            movieCacheDataModule,
            apiKey
        )


    @Provides
    @Singleton
    fun providerTvShowRepository(
        tvShowLocalDataModule: TvShowLocalDataSource,
        tvShowRemoteDataSource: RemoteDataSource,
        tvShowCacheDataModule: TvShowCacheDataSource,
        @Named("apiKey") apiKey: String
    ): TvShowRepository =
        TvShowRepositoryImpl(
            tvShowLocalDataModule,
            tvShowRemoteDataSource,
            tvShowCacheDataModule,
            apiKey
        )


    @Provides
    @Singleton
    fun providerArtistRepository(
        artistLocalDataModule: ArtistLocalDataSource,
        artistRemoteDataModule: RemoteDataSource,
        artistCacheDataModule: ArtistCacheDataSource,
        @Named("apiKey") apiKey: String
    ): ArtistRepository =
        ArtistRepositoryImpl(
            artistLocalDataModule,
            artistRemoteDataModule,
            artistCacheDataModule,
            apiKey
        )

}