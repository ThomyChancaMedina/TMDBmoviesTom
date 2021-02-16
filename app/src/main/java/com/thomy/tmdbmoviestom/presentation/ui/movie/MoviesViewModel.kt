package com.thomy.tmdbmoviestom.presentation.ui.movie

import androidx.lifecycle.ViewModel
import com.example.usecase.movies.GetMoviesUseCase
import com.example.usecase.movies.UpdateMoviesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovie() = getMoviesUseCase.invoke().take(1).flatMapIterable { it }
        .toList()
        .toObservable()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())!!

    fun updateMovies() = updateMoviesUseCase.invoke()


}