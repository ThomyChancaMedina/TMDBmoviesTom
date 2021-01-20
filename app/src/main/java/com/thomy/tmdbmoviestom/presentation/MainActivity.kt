package com.thomy.tmdbmoviestom.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.thomy.tmdbmoviestom.R
import com.thomy.tmdbmoviestom.databinding.ActivityMainNavBinding
import com.thomy.tmdbmoviestom.presentation.common.app
import com.thomy.tmdbmoviestom.presentation.common.getViewModel
import com.thomy.tmdbmoviestom.presentation.ui.artist.ArtistsFragment
import com.thomy.tmdbmoviestom.presentation.ui.movie.MoviesFragment
import com.thomy.tmdbmoviestom.presentation.ui.tvshow.TvShowFragment


class MainActivity : AppCompatActivity() {


    private lateinit var component: MainActivityComponent
    private val viewModel: MainViewModel by lazy { getViewModel { component.mainViewModel } }

    private lateinit var binding: ActivityMainNavBinding

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =   ActivityMainNavBinding.inflate(layoutInflater).apply {
            setContentView(root)

            setSupportActionBar(includeMain.toolbar)


            component = app.appComponent.plus(MainActivityModule())


            val toggle= ActionBarDrawerToggle(
                this@MainActivity,drawerLayout,includeMain.toolbar,
                R.string.open_nav_drawer, R.string.close_nav_drawer
            )

            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            val fragment:Fragment

            includeMain.bottomNavigation.apply {

                setOnNavigationItemSelectedListener { item ->
                    when (item.itemId) {
                        R.id.action_popular -> {
                            Log.d("TAG", "onCreate: thomy:: entro "+"action_popular")
                            openFragment(MoviesFragment())
                            true

                        }
                        R.id.action_highest_rate -> {
                            openFragment(TvShowFragment())
                            true
                        }
                        R.id.action_upcoming -> {
                            Log.d("TAG", "onCreate: thomy:: entro "+"action_upcoming")
                            openFragment(ArtistsFragment())
                            true

                        }
                        else -> throw RuntimeException("Unknown sortType to replace fragment")
                    }
                }

            }

            val response = viewModel.getMovie()

            response.subscribe(
                {
                    Log.d("TAG", "onCreate: thomy::: " + it[1].title)

                }
            )
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .addToBackStack(null).commit()
    }
}