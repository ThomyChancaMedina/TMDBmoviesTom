package com.thomy.tmdbmoviestom.presentation.ui.artist


import com.thomy.tmdbmoviestom.usecase.artist.GetArtistUseCase
import com.thomy.tmdbmoviestom.usecase.artist.UpdateArtistsUseCase
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class ArtistsFragmentModule {

    @Provides
    fun providerArtistsViewModelFactory(
        getArtistsUserCase: GetArtistUseCase,
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