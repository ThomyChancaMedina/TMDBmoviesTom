package com.thomy.tmdbmoviestom.presentation


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.thomy.tmdbmoviestom.R
import com.thomy.tmdbmoviestom.databinding.ActivityMainBinding
import com.thomy.tmdbmoviestom.presentation.common.addFragmentToActivity
import com.thomy.tmdbmoviestom.presentation.common.replaceFragmentInActivity
import com.thomy.tmdbmoviestom.presentation.ui.artist.ArtistsFragment
import com.thomy.tmdbmoviestom.presentation.ui.movie.MoviesFragment
import com.thomy.tmdbmoviestom.presentation.ui.tvshow.TvShowFragment


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)

            if (savedInstanceState == null) {
                addFragmentToActivity(TvShowFragment(), R.id.fragment_container)
            }

            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.main_fragment_container) as NavHostFragment
            val navController = navHostFragment.navController

            NavigationUI.setupWithNavController(bottomNavigation, navController)

            navController.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.moviesFragment -> bottomNavigation.visibility = View.GONE
                    R.id.tvShowFragment -> bottomNavigation.visibility = View.GONE
                    R.id.artistsFragment -> bottomNavigation.visibility = View.GONE
                    else -> bottomNavigation.visibility = View.VISIBLE
                }
            }

            bottomNavigation.apply {

                setOnNavigationItemSelectedListener { item ->
                    when (item.itemId) {
                        R.id.action_popular_movie -> {
                            replaceFragmentInActivity(TvShowFragment(), R.id.fragment_container)
                            true
                        }
                        R.id.action_tv_series -> {
                            replaceFragmentInActivity(MoviesFragment(), R.id.fragment_container)
                            true
                        }
                        R.id.action_actors -> {
                            replaceFragmentInActivity(ArtistsFragment(), R.id.fragment_container)
                            true
                        }
                        else -> false
                    }
                }
            }


        }
    }
}