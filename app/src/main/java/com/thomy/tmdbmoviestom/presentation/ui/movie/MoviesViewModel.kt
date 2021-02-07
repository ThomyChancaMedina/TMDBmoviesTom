package com.thomy.tmdbmoviestom.presentation.ui.movie

import androidx.lifecycle.ViewModel
import com.thomy.tmdbmoviestom.usecase.movie.GetMoviesUseCase
import com.thomy.tmdbmoviestom.usecase.movie.UpdateMoviesUseCase


class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovie() = getMoviesUseCase.invoke()

    fun updateMovies() = updateMoviesUseCase.invoke()


}