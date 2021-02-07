package com.thomy.tmdbmoviestom.data.db.artist

import com.example.data.source.artists.ArtistLocalDataSource
import com.example.domain.Artist
import io.reactivex.Flowable

class ArtistsRoomDataSource(private val artistDao: ArtistDao):ArtistLocalDataSource {
    override fun getArtists(): Flowable<List<Artist>> = artistDao.getArtists()

    override fun saveArtistsToDB(artists: List<Artist>)=artistDao.saveArtists(artists)

    override fun clearAll() = artistDao.deleteAllArtists()
}