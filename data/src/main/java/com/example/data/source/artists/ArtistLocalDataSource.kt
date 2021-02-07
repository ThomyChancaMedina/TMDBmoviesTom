package com.example.data.source.artists

import com.example.domain.Artist
import io.reactivex.Flowable

interface ArtistLocalDataSource {
    fun getArtists(): Flowable<List<Artist>>
    fun saveArtistsToDB(artists: List<Artist>)
    fun clearAll()
}