package com.example.usecase


import com.example.domain.Movie
import io.reactivex.Observable

class UpdateMoviesUseCase(private val movieRepository: com.example.data.MovieRepositoryImpl) {
    fun execute(): Observable<List<Movie>> = movieRepository.updateMovies()
}
