package com.example.data.source.tvshows

import com.example.domain.TvShow
import io.reactivex.Flowable

interface TvShowCacheDataSource {
    fun getTvShowsFromCache(): Flowable<List<TvShow>>
    fun saveTvShowsToCache(tvShows: List<TvShow>)
}