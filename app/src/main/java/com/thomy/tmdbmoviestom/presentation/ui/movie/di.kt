package com.thomy.tmdbmoviestom.presentation.ui.movie



import com.example.usecase.movies.GetMoviesUseCase
import com.example.usecase.movies.UpdateMoviesUseCase
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