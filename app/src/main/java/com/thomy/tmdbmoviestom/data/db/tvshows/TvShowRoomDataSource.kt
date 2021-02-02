package com.thomy.tmdbmoviestom.data.db.tvshows

import com.example.data.source.tvshows.TvShowLocalDataSource
import com.example.domain.TvShow
import io.reactivex.Flowable

class TvShowRoomDataSource(private val tvShowDao: TvShowDao) : TvShowLocalDataSource {
    override fun getTvShows(): Flowable<List<TvShow>> = tvShowDao.getTvShows()

    override fun saveTvShowsToDB(tvShows: List<TvShow>) = tvShowDao.saveTvShows(tvShows)

    override fun clearAll() = tvShowDao.deleteAllTvShows()

}