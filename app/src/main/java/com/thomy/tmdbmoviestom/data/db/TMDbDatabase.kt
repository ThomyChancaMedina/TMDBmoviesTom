package com.thomy.tmdbmoviestom.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.Artist
import com.example.domain.Movie
import com.example.domain.TvShow
import com.thomy.tmdbmoviestom.data.db.artist.ArtistDao
import com.thomy.tmdbmoviestom.data.db.movies.MovieDao
import com.thomy.tmdbmoviestom.data.db.tvshows.TvShowDao


@Database(
    entities = [Movie::class,TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDbDatabase : RoomDatabase(){
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao():TvShowDao
    abstract fun artistDao():ArtistDao
}