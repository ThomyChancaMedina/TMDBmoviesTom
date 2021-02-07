package com.example.data.source.artists

import com.example.domain.Artist
import io.reactivex.Flowable

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {

    private var artistList: MutableList<Artist> = ArrayList()

    override fun getArtistsFromCache(): Flowable<List<Artist>> = Flowable.just(artistList)

    override fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList.addAll(artists)
    }
}