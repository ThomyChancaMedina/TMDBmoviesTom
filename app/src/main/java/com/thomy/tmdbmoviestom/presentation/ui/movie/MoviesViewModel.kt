package com.thomy.tmdbmoviestom.presentation.ui.movie

import androidx.lifecycle.ViewModel
import com.example.usecase.movies.GetMoviesUseCase
import com.example.usecase.movies.UpdateMoviesUseCase

class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovie() = getMoviesUseCase.invoke()

    fun updateMovies() = updateMoviesUseCase.invoke()


}