package com.example.usecase.tvshows


import com.example.data.repository.tvshows.TvShowRepository
import com.example.domain.TvShow
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    fun invoke():Observable<List<TvShow>> =
        tvShowRepository.getTvShows()
}