package com.thomy.tmdbmoviestom.presentation.ui.artist

import androidx.lifecycle.ViewModel
import com.example.usecase.artists.GetArtistsUseCase
import com.example.usecase.artists.UpdateArtistsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ArtistsViewModel(
    private val getArtistsUserCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
):ViewModel() {

    fun getArtists()= getArtistsUserCase.invoke().take(1).flatMapIterable { it }.toList().toObservable()
        .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())!!

    fun updateArtists()=updateArtistsUseCase.invoke()
}