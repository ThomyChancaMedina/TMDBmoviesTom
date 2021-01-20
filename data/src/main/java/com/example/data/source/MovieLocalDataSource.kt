package com.example.data.source



import com.example.domain.Movie
import io.reactivex.Flowable

interface MovieLocalDataSource {
    fun getMovies(): Flowable<List<Movie>>
    fun saveMoviesToDB(movies: List<Movie>)
    fun clearAll()
}