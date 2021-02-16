package com.thomy.tmdbmoviestom.di.core


import com.example.data.repository.artists.ArtistRepository
import com.example.data.repository.movies.MovieRepository
import com.example.data.repository.tvshows.TvShowRepository
import com.example.usecase.artists.GetArtistsUseCase
import com.example.usecase.artists.UpdateArtistsUseCase
import com.example.usecase.movies.GetMoviesUseCase
import com.example.usecase.movies.UpdateMoviesUseCase
import com.example.usecase.tvshows.GetTvShowsUseCase
import com.example.usecase.tvshows.UpdateTvShowsUseCase

import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    //movies
    @Provides
    fun providerGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase =
        GetMoviesUseCase(movieRepository)

    @Provides
    fun providerUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase =
        UpdateMoviesUseCase(movieRepository)

    //tvShows
    @Provides
    fun providerGetTvShowsUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase =
        GetTvShowsUseCase(tvShowRepository)

    @Provides
    fun providerUpdateTvShowsUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUseCase =
        UpdateTvShowsUseCase(tvShowRepository)


    //artists
    @Provides
    fun providerGetArtistsUseCase(artistRepository: ArtistRepository): GetArtistsUseCase =
        GetArtistsUseCase(artistRepository)

    @Provides
    fun providerUpdateArtistsUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase =
        UpdateArtistsUseCase(artistRepository)

}