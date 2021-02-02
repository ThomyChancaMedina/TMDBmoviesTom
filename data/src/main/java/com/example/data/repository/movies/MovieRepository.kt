package com.example.data.repository.movies

import com.example.domain.Movie
import io.reactivex.Observable


interface MovieRepository {
    fun getMovies(): Observable<List<Movie>>
    fun updateMovies(): Observable<List<Movie>>

}
