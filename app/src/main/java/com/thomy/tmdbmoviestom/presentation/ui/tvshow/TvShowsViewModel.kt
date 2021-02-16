package com.thomy.tmdbmoviestom.presentation.ui.tvshow

import androidx.lifecycle.ViewModel
import com.example.usecase.tvshows.GetTvShowsUseCase
import com.example.usecase.tvshows.UpdateTvShowsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class TvShowsViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {
    fun getTvShow() = getTvShowsUseCase.invoke().take(1).flatMapIterable { it }.toList().toObservable()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())!!

    fun updateTvShow() = updateTvShowsUseCase.invoke()
}