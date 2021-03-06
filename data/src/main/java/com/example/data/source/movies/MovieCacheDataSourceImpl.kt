package com.example.data.source.movies


import com.example.domain.Movie
import io.reactivex.Flowable

class MovieCacheDataSourceImpl : MovieCacheDataSource {

    private var moviesList: MutableList<Movie> = ArrayList()


    override fun getMoviesFromCache(): Flowable<List<Movie>> {
        return Flowable.just(moviesList)
    }

    override fun saveMoviesToCache(movies: List<Movie>) {
        moviesList.clear()
        moviesList.addAll(movies)
    }
}