package com.example.data.source.movies



import com.example.domain.Movie
import io.reactivex.Flowable

interface MovieCacheDataSource {
    fun getMoviesFromCache(): Flowable<List<Movie>>
    fun saveMoviesToCache(movies: List<Movie>)
}
