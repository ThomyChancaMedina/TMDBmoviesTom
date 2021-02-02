package com.thomy.tmdbmoviestom.presentation.ui.tvshow

import androidx.lifecycle.ViewModel
import com.example.usecase.tvshows.GetTvShowsUseCase
import com.example.usecase.tvshows.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {
    fun getTvShow() = getTvShowsUseCase.invoke()
    fun updateTvShow() = updateTvShowsUseCase.invoke()
}