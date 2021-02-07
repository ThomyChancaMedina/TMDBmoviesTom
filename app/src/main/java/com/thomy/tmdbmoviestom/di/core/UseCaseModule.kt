package com.thomy.tmdbmoviestom.di.core


import com.example.data.repository.artists.ArtistRepository
import com.example.data.repository.movies.MovieRepository
import com.example.data.repository.tvshows.TvShowRepository
import com.thomy.tmdbmoviestom.usecase.artist.GetArtistUseCase
import com.thomy.tmdbmoviestom.usecase.artist.UpdateArtistsUseCase
import com.thomy.tmdbmoviestom.usecase.movie.GetMoviesUseCase
import com.thomy.tmdbmoviestom.usecase.movie.UpdateMoviesUseCase
import com.thomy.tmdbmoviestom.usecase.tvshow.GetTvShowsUseCase
import com.thomy.tmdbmoviestom.usecase.tvshow.UpdateTvShowsUseCase
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
    fun providerGetArtistsUseCase(artistRepository: ArtistRepository): GetArtistUseCase =
        GetArtistUseCase(artistRepository)

    @Provides
    fun providerUpdateArtistsUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase =
        UpdateArtistsUseCase(artistRepository)

}