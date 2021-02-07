package com.thomy.tmdbmoviestom.data.db.artist

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.Artist
import io.reactivex.Flowable

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveArtists(artists: List<Artist>)

    @Query("DELETE FROM popular_artists")
    fun deleteAllArtists()

    @Query("SELECT * FROM popular_artists")
    fun getArtists(): Flowable<List<Artist>>
}