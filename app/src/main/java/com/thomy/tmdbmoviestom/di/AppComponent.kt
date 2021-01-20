package com.thomy.tmdbmoviestom.di


import android.app.Application
import com.thomy.tmdbmoviestom.di.core.*
import com.thomy.tmdbmoviestom.presentation.MainActivityComponent
import com.thomy.tmdbmoviestom.presentation.MainActivityModule
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
    fun plus(module: MainActivityModule): MainActivityComponent

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance app: Application):AppComponent
    }
}