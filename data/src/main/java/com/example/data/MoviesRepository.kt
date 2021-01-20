package com.example.data

import com.example.data.source.MovieCacheDataSource
import com.example.data.source.MovieLocalDataSource
import com.example.data.source.MovieRemoteDataSource
import com.example.domain.Movie
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable

class MoviesRepository(
    private val localDataSource: MovieLocalDataSource,
    private val remoteDataSource: MovieRemoteDataSource,
    private val cacheDataSource: MovieCacheDataSource,
    private val apiKey: String
) : MovieRepositoryImpl {
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