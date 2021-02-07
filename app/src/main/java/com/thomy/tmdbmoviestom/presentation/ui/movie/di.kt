package com.thomy.tmdbmoviestom.presentation.ui.movie


import com.thomy.tmdbmoviestom.usecase.movie.GetMoviesUseCase
import com.thomy.tmdbmoviestom.usecase.movie.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class MoviesFragmentModule {

    @Provides
    fun providerMoviesViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ) =
        MoviesViewModel(
            getMoviesUseCase,
            updateMoviesUseCase
        )
}


@Subcomponent(modules = [MoviesFragmentModule::class])
interface MoviesFragmentComponent {

    val moviesViewModel: MoviesViewModel
}