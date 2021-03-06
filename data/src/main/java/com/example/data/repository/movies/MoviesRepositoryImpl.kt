package com.example.data.repository.movies

import com.example.data.source.RemoteDataSource
import com.example.data.source.movies.MovieCacheDataSource
import com.example.data.source.movies.MovieLocalDataSource
import com.example.domain.Movie
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable

class MoviesRepositoryImpl(
    private val localDataSource: MovieLocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val cacheDataSource: MovieCacheDataSource,
    private val apiKey: String
) : MovieRepository {
    override fun getMovies(): Observable<List<Movie>> = getMoviesFromCache().toObservable()

    override fun updateMovies(): Observable<List<Movie>> = getMoviesFromAPI()
        .doOnNext { list ->

            localDataSource.clearAll()
            localDataSource.saveMoviesToDB(list)
            cacheDataSource.saveMoviesToCache(list)

        }

    private fun getMoviesFromAPI(): Observable<List<Movie>> = remoteDataSource.getMovies(apiKey)
        .doOnNext {


        }
        .map { list ->
            list
        }

    private fun getMoviesFromDB(): Flowable<List<Movie>> {

        return localDataSource.getMovies().take(1).flatMap {
            if (it.isNotEmpty()) {
                Flowable.just(it)
            } else {
                Flowable.empty()
            }
        }.switchIfEmpty(
            getMoviesFromAPI().map {
                localDataSource.saveMoviesToDB(it)
                it
            }.toFlowable(BackpressureStrategy.ERROR)
        )
    }

    private fun getMoviesFromCache(): Flowable<List<Movie>> {
        return cacheDataSource.getMoviesFromCache().take(1).flatMap {
            if (it.isNotEmpty()) {
                Flowable.just(it)
            } else {
                Flowable.empty()
            }
        }.switchIfEmpty(
            getMoviesFromDB().map {
                cacheDataSource.saveMoviesToCache(it)
                it
            })
    }
}