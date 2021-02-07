package com.thomy.tmdbmoviestom.presentation.ui.artist

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.domain.Artist
import com.thomy.tmdbmoviestom.R
import com.thomy.tmdbmoviestom.databinding.FragmentArtistsBinding
import com.thomy.tmdbmoviestom.presentation.common.appF
import com.thomy.tmdbmoviestom.presentation.common.getViewModelF
import com.thomy.tmdbmoviestom.presentation.ui.movie.MoviesAdapter


class ArtistsFragment : Fragment(), OnItemClickListenerArtist {

    private val TAG = ArtistsFragment::class.java.simpleName

    private lateinit var component: ArtistsFragmentComponent
    private val viewModel: ArtistsViewModel by lazy { getViewModelF { component.artistsViewModel } }

    private lateinit var adapter: ArtistsAdapter
    private lateinit var binding: FragmentArtistsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_artists, container, false)
        component = appF.appComponent.plus(ArtistsFragmentModule())



        initRecyclerView()
//        updateArtist()

        return binding.root
    }

    private fun initRecyclerView() {

        adapter = ArtistsAdapter(this@ArtistsFragment)
        binding.artistRecyclerView.adapter = adapter
        displayPopularArtist()
    }

    @SuppressLint("LogNotTimber")
    private fun displayPopularArtist() {
        with(binding) {
            artistProgressBar.visibility = View.VISIBLE
            val responseObservable = viewModel.getArtists()

            responseObservable.subscribe(
                { artistList ->
                    adapter.artists=artistList
                    adapter.notifyDataSetChanged()
                    Log.d(TAG, "displayPopularArtist: ${artistList.size}")
                },
                {
                    Log.i(TAG, "displayPopularArtist: e = ${it.message}")
                    artistProgressBar.visibility = View.GONE
                },
                {
                    Log.i(TAG, "displayPopularArtist: ")
                    artistProgressBar.visibility = View.GONE
                }
            )
        }
    }

    @SuppressLint("LogNotTimber")
    private fun updateArtist() {
        with(binding) {
            artistProgressBar.visibility = View.VISIBLE
            val response = viewModel.updateArtists()
            response.subscribe(
                { listArtist ->
                    adapter.artists=listArtist
                    adapter.notifyDataSetChanged()
                    artistProgressBar.visibility = View.GONE
                    Log.i(TAG, "updateArtist: ${listArtist.size}")
                },
                { e ->
                    Log.i(TAG, "updateArtist: e = ${e.message}")
                },

                { artistProgressBar.visibility = View.GONE }
            )
        }
    }


    override fun onItemCLicked(artist: Artist) {
        TODO("Not yet implemented")
    }

}