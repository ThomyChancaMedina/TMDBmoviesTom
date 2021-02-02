package com.example.usecase.movies


import com.example.data.repository.movies.MovieRepository
import com.example.domain.Movie
import io.reactivex.Observable
//import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    fun invoke(): Observable<List<Movie>> =
        movieRepository.getMovies().take(1).flatMapIterable { it }.flatMap { movie ->

                Observable.just(movie)

        }.toList().toObservable().subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
}
