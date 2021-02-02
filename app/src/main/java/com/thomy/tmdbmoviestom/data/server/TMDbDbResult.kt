package com.thomy.tmdbmoviestom.data.server

import com.example.domain.Movie
import com.example.domain.TvShow
import com.google.gson.annotations.SerializedName


data class MovieList(
    @SerializedName("results")
    val moviesResult: List<Movie>,
)

data class TvShowList(
    @SerializedName("results")
    val tvShowsResult: List<TvShow>
)









