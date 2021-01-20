package com.thomy.tmdbmoviestom.presentation


import com.example.usecase.GetMoviesUseCase
import com.example.usecase.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class MainActivityModule {

    @Provides

    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ) =
        MainViewModel(
            getMoviesUseCase,
            updateMoviesUseCase
        )
}


@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {

    val mainViewModel: MainViewModel
}