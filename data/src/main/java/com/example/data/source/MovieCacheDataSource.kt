package com.example.data.source



import com.example.domain.Movie
import io.reactivex.Flowable

interface MovieCacheDataSource {
    fun getMoviesFromCache(): Flowable<List<Movie>>
    fun saveMoviesToCache(movies: List<Movie>)
}
