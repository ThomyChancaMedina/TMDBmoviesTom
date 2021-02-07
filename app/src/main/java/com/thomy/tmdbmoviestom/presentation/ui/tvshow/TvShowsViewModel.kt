package com.thomy.tmdbmoviestom.presentation.ui.tvshow

import androidx.lifecycle.ViewModel
import com.thomy.tmdbmoviestom.usecase.tvshow.GetTvShowsUseCase
import com.thomy.tmdbmoviestom.usecase.tvshow.UpdateTvShowsUseCase


class TvShowsViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {
    fun getTvShow() = getTvShowsUseCase.invoke()
    fun updateTvShow() = updateTvShowsUseCase.invoke()
}