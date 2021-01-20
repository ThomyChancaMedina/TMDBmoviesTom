package com.example.data.source




import com.example.domain.Movie
import io.reactivex.Observable

interface MovieRemoteDataSource {
    fun getMovies(apiKey: String): Observable<List<Movie>>

}