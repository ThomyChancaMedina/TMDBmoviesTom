package com.thomy.tmdbmoviestom.di.core


import com.example.data.MovieRepositoryImpl
import com.example.usecase.GetMoviesUseCase
import com.example.usecase.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun providerGetModuleUseCase(movieRepository: MovieRepositoryImpl): GetMoviesUseCase =
        GetMoviesUseCase(movieRepository)

    @Provides
    fun providerUpdateMovieUseCase(movieRepository: MovieRepositoryImpl): UpdateMoviesUseCase =
        UpdateMoviesUseCase(movieRepository)
}