package com.example.data.source.artists

import com.example.domain.Artist
import io.reactivex.Flowable

interface ArtistCacheDataSource {
    fun getArtistsFromCache(): Flowable<List<Artist>>
    fun saveArtistsToCache(artists: List<Artist>)
}