package com.example.data.repository.tvshows

import com.example.domain.TvShow
import io.reactivex.Observable

interface TvShowRepository {
    fun getTvShows():Observable<List<TvShow>>
    fun updateTvShows():Observable<List<TvShow>>
}