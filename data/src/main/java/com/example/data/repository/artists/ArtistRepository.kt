package com.example.data.repository.artists

import com.example.domain.Artist
import io.reactivex.Observable

interface ArtistRepository {
    fun getArtists(): Observable<List<Artist>>
    fun updateArtists(): Observable<List<Artist>>
}