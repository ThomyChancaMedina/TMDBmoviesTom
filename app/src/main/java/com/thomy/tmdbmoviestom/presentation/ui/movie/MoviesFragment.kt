package com.thomy.tmdbmoviestom.presentation.ui.movie

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.domain.Movie
import com.thomy.tmdbmoviestom.databinding.FragmentMovieBinding
import com.thomy.tmdbmoviestom.presentation.common.appF
import com.thomy.tmdbmoviestom.presentation.common.getViewModelF


class MoviesFragment : Fragment(), OnItemClickListenerMovie {

    private val TAG = MoviesFragment::class.java.simpleName

    private lateinit var component: MoviesFragmentComponent
    private val viewModel: MoviesViewModel by lazy { getViewModelF { component.moviesViewModel } }

    private lateinit var adapter: MoviesAdapter
    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMovieBinding.inflate(inflater, container, false)
        component = appF.appComponent.plus(MoviesFragmentModule())
        adapter = MoviesAdapter(this@MoviesFragment)

        binding.movieRecyclerView.adapter = adapter

        displayPopularMovies()
        updateMovies()

        return binding.root
    }


    @SuppressLint("CheckResult", "LogNotTimber")
    private fun displayPopularMovies() {
        with(binding) {
            movieProgressBar.visibility = View.VISIBLE

            val responseObservable = viewModel.getMovie()

            responseObservable.subscribe(
                { movieList ->
                    adapter.movies = movieList
                    adapter.notifyDataSetChanged()

                    Log.d(TAG, "displayPopularMovies: " + Thread.currentThread().id.toString())

                },
                {
                    movieProgressBar.visibility = View.GONE
                    Log.e(TAG, it.message.toString())
                },
                { movieProgressBar.visibility = View.GONE }
            )
        }


    }

    @SuppressLint("CheckResult, LogNotTimber")
    private fun updateMovies() {
        with(binding) {
            movieProgressBar.visibility = View.VISIBLE
            val response = viewModel.updateMovies()

            response.subscribe({ listMovies ->
                adapter.movies = listMovies
                adapter.notifyDataSetChanged()
                movieProgressBar.visibility = View.GONE


            }, { e -> Log.i(TAG, e.toString()) },

                { movieProgressBar.visibility = View.GONE }
            )
        }

    }

    override fun onItemCLicked(movie: Movie) {
        TODO("Not yet implemented")
    }


}