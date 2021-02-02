package com.example.data.source.tvshows

import com.example.domain.TvShow
import io.reactivex.Flowable

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {

    private var tvShowsList:MutableList<TvShow> = ArrayList()

    override fun getTvShowsFromCache(): Flowable<List<TvShow>> {
        return Flowable.just(tvShowsList)
    }

    override fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowsList.clear()
        tvShowsList.addAll(tvShows)
    }
}