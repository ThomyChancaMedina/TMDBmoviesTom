package com.thomy.tmdbmoviestom.usecase.tvshow



import com.example.data.repository.tvshows.TvShowRepository
import com.example.domain.TvShow
import io.reactivex.Observable


class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    fun invoke(): Observable<List<TvShow>> = tvShowRepository.updateTvShows()
}
