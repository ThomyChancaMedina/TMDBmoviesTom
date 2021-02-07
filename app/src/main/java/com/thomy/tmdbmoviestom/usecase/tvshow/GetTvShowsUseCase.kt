package com.thomy.tmdbmoviestom.usecase.tvshow


import com.example.data.repository.tvshows.TvShowRepository
import com.example.domain.TvShow
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    fun invoke(): Observable<List<TvShow>> =
        tvShowRepository.getTvShows().take(1).flatMapIterable { it }.toList().toObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}
