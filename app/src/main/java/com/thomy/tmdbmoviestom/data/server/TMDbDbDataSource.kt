package com.thomy.tmdbmoviestom.data.server

import com.example.data.source.MovieRemoteDataSource
import com.example.domain.Movie
import io.reactivex.Observable

class TMDbDbDataSource(
    private val tmdbService: TMDbDb,
): MovieRemoteDataSource {
    override fun getMovies(apiKey: String): Observable<List<Movie>> =
        tmdbService.service
            .getPopularMovies(apiKey)
            .map { it.results }

}