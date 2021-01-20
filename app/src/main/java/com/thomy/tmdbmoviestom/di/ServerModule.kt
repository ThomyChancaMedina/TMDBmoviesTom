package com.thomy.tmdbmoviestom.di


import com.thomy.tmdbmoviestom.data.server.TMDbDb
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ServerModule {

    @Singleton
    @Provides
    @Named("baseUrl")
    fun baseUrlProvider() = "https://api.themoviedb.org/3/"

    @Singleton
    @Provides
    fun movieDBProvider(@Named("baseUrl") baseUrl: String) = TMDbDb(baseUrl)


}