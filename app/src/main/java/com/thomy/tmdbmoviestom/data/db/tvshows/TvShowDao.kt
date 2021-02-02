package com.thomy.tmdbmoviestom.data.db.tvshows

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.TvShow
import io.reactivex.Flowable

@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTvShows(tvShow: List<TvShow>)

    @Query("DELETE FROM popular_tvshows")
    fun deleteAllTvShows()

    @Query("SELECT * FROM popular_tvshows")
    fun getTvShows():Flowable<List<TvShow>>

}