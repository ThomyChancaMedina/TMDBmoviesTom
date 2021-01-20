package com.thomy.tmdbmoviestom

import android.app.Application
import com.thomy.tmdbmoviestom.di.AppComponent
import com.thomy.tmdbmoviestom.di.DaggerAppComponent



open class TmdbApp : Application() {

  lateinit var appComponent: AppComponent
      private set

    override fun onCreate() {
        super.onCreate()
        appComponent = createMovieSubComponent()


    }

   open fun createMovieSubComponent() = DaggerAppComponent.factory().create(this)

}