package com.thomy.tmdbmoviestom.presentation.ui.artist

import androidx.lifecycle.ViewModel
import com.thomy.tmdbmoviestom.usecase.artist.GetArtistUseCase
import com.thomy.tmdbmoviestom.usecase.artist.UpdateArtistsUseCase

class ArtistsViewModel(
    private val getArtistsUserCase: GetArtistUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
):ViewModel() {

    fun getArtists()= getArtistsUserCase.invoke()

    fun updateArtists()=updateArtistsUseCase.invoke()
}