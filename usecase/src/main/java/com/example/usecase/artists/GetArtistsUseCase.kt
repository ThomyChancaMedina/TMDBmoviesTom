package com.example.usecase.artists

import com.example.data.repository.artists.ArtistRepository
import com.example.domain.Artist
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class GetArtistsUseCase(private val artistRepository: ArtistRepository){
    fun invoke():Observable<List<Artist>> =
        artistRepository.getArtists().take(1).flatMapIterable { it }.flatMap { artist->
        Observable.just(artist)

        }.toList().toObservable().subscribeOn(Schedulers.io())
}