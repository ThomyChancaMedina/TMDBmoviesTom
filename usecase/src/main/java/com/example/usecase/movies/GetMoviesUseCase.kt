package com.example.usecase.movies


import com.example.data.repository.movies.MovieRepository
import com.example.domain.Movie
import io.reactivex.Observable


class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    fun invoke(): Observable<List<Movie>> =
        movieRepository.getMovies()
}
