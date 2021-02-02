package com.thomy.tmdbmoviestom.data.server

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDbDbService {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): Observable<MovieList>

    @GET("tv/popular")
    fun getPopularTvShows(
        @Query("api_key") apiKey: String
    ): Observable<TvShowList>

}