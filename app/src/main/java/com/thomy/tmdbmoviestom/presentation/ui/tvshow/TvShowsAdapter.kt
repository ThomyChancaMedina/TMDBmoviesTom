package com.thomy.tmdbmoviestom.presentation.ui.tvshow

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.TvShow
import com.thomy.tmdbmoviestom.R
import com.thomy.tmdbmoviestom.databinding.TvshowItemBinding
import com.thomy.tmdbmoviestom.presentation.common.basicDiffUtil
import com.thomy.tmdbmoviestom.presentation.common.inflate
import com.thomy.tmdbmoviestom.presentation.common.loadUrl


class TvShowsAdapter(
    private val onClickListener: OnItemClickListenerTvShow
) : RecyclerView.Adapter<TvShowsAdapter.ViewHolder>() {

    var tvShows: List<TvShow> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.tvshow_item, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = tvShows.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvShow = tvShows[position]
        holder.bind(tvShow, onClickListener)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val viewBinding = TvshowItemBinding.bind(view)
        fun bind(tvShow: TvShow, itemClickListener: OnItemClickListenerTvShow) {
            with(viewBinding) {
                cardViewBack.setOnClickListener {
                    itemClickListener.onItemCLicked(tvShow)
                }
                itemTitle.text = tvShow.name
                itemCover.loadUrl("https://image.tmdb.org/t/p/w500/${tvShow.posterPath}")
            }
        }

    }

}

interface OnItemClickListenerTvShow {
    fun onItemCLicked(tvShow: TvShow)
}