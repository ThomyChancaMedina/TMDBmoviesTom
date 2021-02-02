package com.thomy.tmdbmoviestom.presentation.ui.tvshow

import com.example.usecase.tvshows.GetTvShowsUseCase
import com.example.usecase.tvshows.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class TvShowsFragmentModule {

    @Provides
    fun providerTvShowsViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase,
    ) = TvShowViewModel(
        getTvShowsUseCase,
        updateTvShowsUseCase
    )
}

@Subcomponent(modules = [TvShowsFragmentModule::class])
interface TvShowsFragmentComponent {
    val tvShowViewModel: TvShowViewModel
}