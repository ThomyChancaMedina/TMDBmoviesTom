package com.example.data.source




import com.example.domain.Movie
import com.example.domain.TvShow
import io.reactivex.Observable

interface RemoteDataSource {
    fun getMovies(apiKey: String): Observable<List<Movie>>
    fun getTvShows(apiKey: String):Observable<List<TvShow>>

}