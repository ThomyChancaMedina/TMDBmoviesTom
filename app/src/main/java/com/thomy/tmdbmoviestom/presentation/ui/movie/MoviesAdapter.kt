package com.thomy.tmdbmoviestom.presentation.ui.movie


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.Movie
import com.thomy.tmdbmoviestom.R
import com.thomy.tmdbmoviestom.databinding.MovieItemBinding
import com.thomy.tmdbmoviestom.presentation.common.basicDiffUtil
import com.thomy.tmdbmoviestom.presentation.common.inflate
import com.thomy.tmdbmoviestom.presentation.common.loadUrl

class MoviesAdapter(
    private val onClickListener: OnItemClickListenerMovie
) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    var movies: List<Movie> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.movie_item, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, onClickListener)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val viewBinding = MovieItemBinding.bind(view)
        fun bind(movie: Movie, itemClickListener: OnItemClickListenerMovie) {
            with(viewBinding) {
                cardViewBack.setOnClickListener {
                    itemClickListener.onItemCLicked(movie)
                }
                movieTitle.text = movie.title
                movieCover.loadUrl("https://image.tmdb.org/t/p/w185/${movie.posterPath}")

            }
        }
    }
}

interface OnItemClickListenerMovie {
    fun onItemCLicked(movie: Movie)
}