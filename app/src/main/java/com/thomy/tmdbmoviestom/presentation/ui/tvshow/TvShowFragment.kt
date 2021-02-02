package com.thomy.tmdbmoviestom.presentation.ui.tvshow

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.domain.TvShow
import com.thomy.tmdbmoviestom.databinding.FragmentTvshowBinding
import com.thomy.tmdbmoviestom.presentation.common.appF
import com.thomy.tmdbmoviestom.presentation.common.getViewModelF


class TvShowFragment : Fragment(), OnItemClickListenerTvShow {

    private val TAG = TvShowFragment::class.java.simpleName

    private lateinit var component: TvShowsFragmentComponent
    private val viewModel: TvShowViewModel by lazy { getViewModelF { component.tvShowViewModel } }

    private lateinit var adapter: TvShowsAdapter
    private lateinit var binding: FragmentTvshowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentTvshowBinding.inflate(inflater, container, false)
        component = appF.appComponent.plus(TvShowsFragmentModule())
        adapter = TvShowsAdapter(this@TvShowFragment)

        binding.tvShowRecyclerView.adapter = adapter

        displayPopularTvShows()
        updateTvShows()

        return binding.root
    }

    @SuppressLint("CheckResult", "LogNotTimber")
    private fun displayPopularTvShows() {
        with(binding) {
            tvShowProgressBar.visibility = View.VISIBLE
            val responseObservable = viewModel.getTvShow()

            responseObservable.subscribe(
                { tvShowList ->
                    adapter.tvShows = tvShowList
                    adapter.notifyDataSetChanged()

                    Log.d(TAG, "displayPopularTvShows: " + Thread.currentThread().id.toString())

                },
                {
                    tvShowProgressBar.visibility = View.GONE
                    Log.e(TAG, it.message.toString())
                }, {
                    tvShowProgressBar.visibility = View.GONE
                }
            )
        }

    }

    @SuppressLint("LogNotTimber")
    private fun updateTvShows() {
        with(binding) {
            tvShowProgressBar.visibility = View.VISIBLE
            val response = viewModel.updateTvShow()
            response.subscribe(
                { listTvShows ->
                    adapter.tvShows = listTvShows
                    adapter.notifyDataSetChanged()
                    tvShowProgressBar.visibility = View.GONE

                },
                { e ->
                    Log.i(TAG, e.toString())
                },
                {
                    tvShowProgressBar.visibility = View.GONE
                }

            )
        }

    }

    override fun onItemCLicked(tvShow: TvShow) {
        TODO("Not yet implemented")
    }


}