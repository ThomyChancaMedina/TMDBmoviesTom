package com.thomy.tmdbmoviestom.data.server

import com.example.data.source.RemoteDataSource
import com.example.domain.Artist
import com.example.domain.Movie
import com.example.domain.TvShow
import io.reactivex.Observable

class TMDbDbDataSource(
    private val tmdbService: TMDbDb,
) : RemoteDataSource {
    override fun getMovies(apiKey: String): Observable<List<Movie>> =
        tmdbService.service
            .getPopularMovies(apiKey)
            .map { it.moviesResult }

    override fun getTvShows(apiKey: String): Observable<List<TvShow>> =
        tmdbService.service
            .getPopularTvShows(apiKey)
            .map { it.tvShowsResult }

    override fun getArtists(apiKey: String): Observable<List<Artist>> =
        tmdbService.service
            .getPopularArtists(apiKey)
            .map { it.artistsResult }


}