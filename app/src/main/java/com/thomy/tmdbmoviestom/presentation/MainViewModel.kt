package com.thomy.tmdbmoviestom.presentation

import androidx.lifecycle.ViewModel
import com.example.usecase.GetMoviesUseCase
import com.example.usecase.UpdateMoviesUseCase

class MainViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {
    fun getMovie()=getMoviesUseCase.execute()
    fun updateMovies()=updateMoviesUseCase.execute()
}