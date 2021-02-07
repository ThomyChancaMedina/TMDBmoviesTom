package com.thomy.tmdbmoviestom.di


import android.app.Application
import androidx.room.Room
import com.example.data.source.RemoteDataSource
import com.example.data.source.artists.ArtistCacheDataSource
import com.example.data.source.artists.ArtistCacheDataSourceImpl
import com.example.data.source.artists.ArtistLocalDataSource
import com.example.data.source.movies.MovieCacheDataSourceImpl
import com.example.data.source.movies.MovieCacheDataSource
import com.example.data.source.movies.MovieLocalDataSource
import com.example.data.source.tvshows.TvShowCacheDataSource
import com.example.data.source.tvshows.TvShowCacheDataSourceImpl
import com.example.data.source.tvshows.TvShowLocalDataSource
import com.thomy.tmdbmoviestom.R
import com.thomy.tmdbmoviestom.data.db.movies.MovieDao
import com.thomy.tmdbmoviestom.data.db.TMDbDatabase
import com.thomy.tmdbmoviestom.data.db.artist.ArtistDao
import com.thomy.tmdbmoviestom.data.db.artist.ArtistsRoomDataSource
import com.thomy.tmdbmoviestom.data.db.movies.MoviesRoomDataSource
import com.thomy.tmdbmoviestom.data.db.tvshows.TvShowDao
import com.thomy.tmdbmoviestom.data.db.tvshows.TvShowRoomDataSource
import com.thomy.tmdbmoviestom.data.server.TMDbDb
import com.thomy.tmdbmoviestom.data.server.TMDbDbDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {


    @Provides
    @Singleton
    fun providerMovieDataBase(app: Application): TMDbDatabase {
        return Room.databaseBuilder(app, TMDbDatabase::class.java, "tmdb-Movie")
            .build()
    }

    @Provides
    @Singleton
    @Named("apiKey")
    fun apiKeyProvider(app: Application): String = app.getString(R.string.api_key)

    @Provides
    fun providerRemoteDataSource(tmDbDbService: TMDbDb): RemoteDataSource =
        TMDbDbDataSource(tmDbDbService)

    //movies
    @Provides
    fun providerMovieDao(tmdbDatabase: TMDbDatabase): MovieDao = tmdbDatabase.movieDao()

    @Provides
    fun providerMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource =
        MoviesRoomDataSource(movieDao)

    @Provides
    fun providerMovieCacheDataSource(): MovieCacheDataSource = MovieCacheDataSourceImpl()

    //tvShows
    @Provides
    fun providerTvShowDao(tmdbDatabase: TMDbDatabase): TvShowDao = tmdbDatabase.tvShowDao()

    @Provides
    fun providerTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource =
        TvShowRoomDataSource(tvShowDao)

    @Provides
    fun providerTvShowCacheDataSource(): TvShowCacheDataSource = TvShowCacheDataSourceImpl()

    //artists
    @Provides
    fun providerArtistDao(tmdbDatabase: TMDbDatabase): ArtistDao = tmdbDatabase.artistDao()

    @Provides
    fun providerArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource =
        ArtistsRoomDataSource(artistDao)

    @Provides
    fun providerArtistCacheDataSource(): ArtistCacheDataSource = ArtistCacheDataSourceImpl()
}