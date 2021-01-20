package com.thomy.tmdbmoviestom.di


import android.app.Application
import androidx.room.Room
import com.example.data.repository.MovieCacheDataSourceImpl
import com.example.data.source.MovieCacheDataSource
import com.example.data.source.MovieLocalDataSource
import com.example.data.source.MovieRemoteDataSource
import com.thomy.tmdbmoviestom.R
import com.thomy.tmdbmoviestom.data.db.MovieDao
import com.thomy.tmdbmoviestom.data.db.RoomDataSource
import com.thomy.tmdbmoviestom.data.db.TMDbDatabase
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
    fun providerMovieDataBase(app:Application): TMDbDatabase {
        return Room.databaseBuilder(app, TMDbDatabase::class.java, "tmdb-Movie")
            .build()
    }

    @Provides
    @Singleton
    @Named("apiKey")
    fun apiKeyProvider(app:Application): String = app.getString(R.string.api_key)

    @Provides
    fun provideMovieDao(tmdbDatabase: TMDbDatabase): MovieDao = tmdbDatabase.movieDao()

    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource =
        RoomDataSource(movieDao)


    @Provides
    fun provideMovieRemoteDataSource(tmDbDbService: TMDbDb): MovieRemoteDataSource =
        TMDbDbDataSource(tmDbDbService)


    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource = MovieCacheDataSourceImpl()
}