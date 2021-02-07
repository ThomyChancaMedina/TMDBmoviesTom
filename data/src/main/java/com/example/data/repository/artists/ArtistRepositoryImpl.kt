package com.example.data.repository.artists

import com.example.data.source.RemoteDataSource
import com.example.data.source.artists.ArtistCacheDataSource
import com.example.data.source.artists.ArtistLocalDataSource
import com.example.domain.Artist
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable

class ArtistRepositoryImpl(
    private val localDataSource: ArtistLocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val cacheDataSource: ArtistCacheDataSource,
    private val apiKey: String
) : ArtistRepository {
    override fun getArtists(): Observable<List<Artist>> = getArtistsFromCache().toObservable()

    override fun updateArtists(): Observable<List<Artist>> = getArtistsFromAPI()
        .doOnNext { list ->
            localDataSource.clearAll()
            localDataSource.saveArtistsToDB(list)
            cacheDataSource.saveArtistsToCache(list)

        }

    private fun getArtistsFromAPI(): Observable<List<Artist>> = remoteDataSource.getArtists(apiKey)
        .doOnNext {

        }
        .map { list ->
            list
        }

    private fun getArtistsFromDB(): Flowable<List<Artist>> =
        localDataSource.getArtists().take(1).flatMap {
            if (it.isNotEmpty()) {
                Flowable.just(it)
            } else {
                Flowable.empty()
            }
        }.switchIfEmpty(
            getArtistsFromAPI().map {
                localDataSource.saveArtistsToDB(it)
                it
            }.toFlowable(BackpressureStrategy.ERROR)
        )

    private fun getArtistsFromCache(): Flowable<List<Artist>> =
        cacheDataSource.getArtistsFromCache().take(1).flatMap {
            if (it.isNotEmpty()) {
                Flowable.just(it)
            } else {
                Flowable.empty()
            }
        }.switchIfEmpty(
            getArtistsFromDB().map {
                cacheDataSource.saveArtistsToCache(it)
                it
            }
        )
}