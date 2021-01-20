package com.example.usecase


import com.example.data.MovieRepositoryImpl
import com.example.domain.Movie
import io.reactivex.Observable
//import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetMoviesUseCase(private val movieRepository: MovieRepositoryImpl) {
    fun execute(): Observable<List<Movie>> =
        movieRepository.getMovies().take(1).flatMapIterable { it }.flatMap { movie ->

                Observable.just(movie)

        }.toList().toObservable().subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
}
