package com.thomy.tmdbmoviestom.presentation.ui.tvshow


import com.thomy.tmdbmoviestom.usecase.tvshow.GetTvShowsUseCase
import com.thomy.tmdbmoviestom.usecase.tvshow.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class TvShowsFragmentModule {

    @Provides
    fun providerTvShowsViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase,
    ) = TvShowsViewModel(
        getTvShowsUseCase,
        updateTvShowsUseCase
    )
}

@Subcomponent(modules = [TvShowsFragmentModule::class])
interface TvShowsFragmentComponent {
    val tvShowViewModel: TvShowsViewModel
}