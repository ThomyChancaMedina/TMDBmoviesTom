package com.thomy.tmdbmoviestom.presentation.ui.artist

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.Artist
import com.thomy.tmdbmoviestom.R
import com.thomy.tmdbmoviestom.databinding.ArtistItemBinding
import com.thomy.tmdbmoviestom.presentation.common.basicDiffUtil
import com.thomy.tmdbmoviestom.presentation.common.inflate
import com.thomy.tmdbmoviestom.presentation.common.loadUrl

class ArtistsAdapter(
    private val onClickListener: OnItemClickListenerArtist
) : RecyclerView.Adapter<ArtistsAdapter.ViewHolder>() {

    var artists: List<Artist> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i("TAG", "onCreateViewHolder: thomy ${artists.size}")
        val view = parent.inflate(R.layout.artist_item, false)
        return ViewHolder(view)
    }

    @SuppressLint("LogNotTimber")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artist = artists[position]
        Log.i("TAG", "onBindViewHolder: Thomy ${artists.size}")
        holder.bind(artist, onClickListener)
    }

    override fun getItemCount(): Int = artists.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val viewBinding = ArtistItemBinding.bind(view)
        fun bind(artist: Artist, itemClickListener: OnItemClickListenerArtist){
            with(viewBinding){
                cardViewBack.setOnClickListener {
                    itemClickListener.onItemCLicked(artist)
                }
                artistTitle.text = artist.name
                artistCover.loadUrl("https://image.tmdb.org/t/p/w500/${artist.profilePath}")
            }
        }

    }

}

interface OnItemClickListenerArtist {
    fun onItemCLicked(artist: Artist)
}