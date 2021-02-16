package com.thomy.tmdbmoviestom.presentation.ui.artist


import com.example.usecase.artists.GetArtistsUseCase
import com.example.usecase.artists.UpdateArtistsUseCase
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class ArtistsFragmentModule {

    @Provides
    fun providerArtistsViewModelFactory(
        getArtistsUserCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ) = ArtistsViewModel(
        getArtistsUserCase,
        updateArtistsUseCase
    )

}

@Subcomponent(modules = [ArtistsFragmentModule::class])
interface ArtistsFragmentComponent {
    val artistsViewModel: ArtistsViewModel
}