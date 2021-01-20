package com.thomy.tmdbmoviestom.data.server



import com.example.domain.Movie
import com.google.gson.annotations.SerializedName


data class MovieList(
    @SerializedName("results")
    val results: List<Movie>,
)









