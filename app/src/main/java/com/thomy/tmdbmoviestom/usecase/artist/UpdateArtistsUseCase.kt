package com.thomy.tmdbmoviestom.usecase.artist




import com.example.data.repository.artists.ArtistRepository
import com.example.domain.Artist
import io.reactivex.Observable


class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    fun invoke(): Observable<List<Artist>> = artistRepository.updateArtists()
}
