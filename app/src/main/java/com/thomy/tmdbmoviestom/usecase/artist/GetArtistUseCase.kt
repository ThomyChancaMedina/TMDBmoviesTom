package com.thomy.tmdbmoviestom.usecase.artist




import com.example.data.repository.artists.ArtistRepository
import com.example.domain.Artist
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class GetArtistUseCase(private val artistRepository: ArtistRepository) {
    fun invoke(): Observable<List<Artist>> =
        artistRepository.getArtists().take(1).flatMapIterable { it }.toList().toObservable()
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}
