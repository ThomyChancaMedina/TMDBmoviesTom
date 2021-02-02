package com.example.data.repository.tvshows

import com.example.data.source.RemoteDataSource
import com.example.data.source.tvshows.TvShowCacheDataSource
import com.example.data.source.tvshows.TvShowLocalDataSource
import com.example.domain.TvShow
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable

class TvShowRepositoryImpl(
    private val localDataSource: TvShowLocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val cacheDataSource: TvShowCacheDataSource,
    private val apiKey: String,
) : TvShowRepository {
    override fun getTvShows(): Observable<List<TvShow>> = getTvShowsFromCache().toObservable()

    override fun updateTvShows(): Observable<List<TvShow>> = getTvShowsFromAPI()
        .doOnNext { list ->
            localDataSource.clearAll()
            localDataSource.saveTvShowsToDB(list)
            cacheDataSource.saveTvShowsToCache(list)
        }

    private fun getTvShowsFromAPI(): Observable<List<TvShow>> = remoteDataSource.getTvShows(apiKey)
        .doOnNext {

        }.map { list ->
            list
        }

    private fun getTvShowsFromDB(): Flowable<List<TvShow>> =
        localDataSource.getTvShows().take(1).flatMap {
            if (it.isNotEmpty()) {
                Flowable.just(it)
            } else {
                Flowable.empty()
            }
        }.switchIfEmpty(
            getTvShowsFromAPI().map {
                localDataSource.saveTvShowsToDB(it)
                it
            }.toFlowable(BackpressureStrategy.ERROR)
        )

    private fun getTvShowsFromCache(): Flowable<List<TvShow>> {
        return cacheDataSource.getTvShowsFromCache().take(1).flatMap {
            if (it.isNotEmpty()) {
                Flowable.just(it)
            } else {
                Flowable.empty()
            }
        }.switchIfEmpty(
            getTvShowsFromDB().map {
                cacheDataSource.saveTvShowsToCache(it)
                it
            }
        )
    }

}