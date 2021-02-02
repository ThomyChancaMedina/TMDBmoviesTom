package com.example.data.source.tvshows

import com.example.domain.TvShow
import io.reactivex.Flowable

interface TvShowLocalDataSource {
    fun getTvShows(): Flowable<List<TvShow>>
    fun saveTvShowsToDB(tvShows: List<TvShow>)
    fun clearAll()
}