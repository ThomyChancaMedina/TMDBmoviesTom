package com.thomy.tmdbmoviestom.data.db

import com.example.data.source.MovieLocalDataSource
import com.example.domain.Movie
import io.reactivex.Flowable

class RoomDataSource(private val movieDao: MovieDao) : MovieLocalDataSource {

    override fun getMovies(): Flowable<List<Movie>> = movieDao.getMovies()

    override fun saveMoviesToDB(movies: List<Movie>) = movieDao.saveMovies(movies)

    override fun clearAll() = movieDao.deleteAllMovies()


}