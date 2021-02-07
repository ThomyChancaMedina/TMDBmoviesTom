package com.example.data.source


import com.example.domain.Artist
import com.example.domain.Movie
import com.example.domain.TvShow
import io.reactivex.Observable

interface RemoteDataSource {
    fun getMovies(apiKey: String): Observable<List<Movie>>
    fun getTvShows(apiKey: String):Observable<List<TvShow>>
    fun getArtists(apiKey: String):Observable<List<Artist>>

}