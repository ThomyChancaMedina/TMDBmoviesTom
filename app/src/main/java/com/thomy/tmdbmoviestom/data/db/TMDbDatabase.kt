package com.thomy.tmdbmoviestom.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.Movie


@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = false
)
abstract class TMDbDatabase : RoomDatabase(){
    abstract fun movieDao():MovieDao
}