package com.thomy.tmdbmoviestom.di


import android.app.Application
import com.thomy.tmdbmoviestom.di.core.*
import com.thomy.tmdbmoviestom.presentation.ui.artist.ArtistsFragmentComponent
import com.thomy.tmdbmoviestom.presentation.ui.artist.ArtistsFragmentModule
import com.thomy.tmdbmoviestom.presentation.ui.movie.MoviesFragmentComponent
import com.thomy.tmdbmoviestom.presentation.ui.movie.MoviesFragmentModule
import com.thomy.tmdbmoviestom.presentation.ui.tvshow.TvShowsFragmentComponent
import com.thomy.tmdbmoviestom.presentation.ui.tvshow.TvShowsFragmentModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        UseCaseModule::class,
        ServerModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {
    fun plus(module: MoviesFragmentModule): MoviesFragmentComponent
    fun plus(module: TvShowsFragmentModule):TvShowsFragmentComponent
    fun plus(module: ArtistsFragmentModule): ArtistsFragmentComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppComponent
    }
}