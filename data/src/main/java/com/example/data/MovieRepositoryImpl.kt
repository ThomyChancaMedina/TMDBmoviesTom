package com.example.data




import com.example.domain.Movie
import io.reactivex.Observable


interface MovieRepositoryImpl {
    fun getMovies(): Observable<List<Movie>>

    fun updateMovies(): Observable<List<Movie>>

}
