package at.phatbl.dogify.repository

import at.phatbl.dogify.api.BreedsApi
import at.phatbl.dogify.util.DispatcherProvider
import kotlinx.coroutines.withContext

internal class BreedsRemoteSource(
    private val api: BreedsApi,
    private val dispatcherProvider: DispatcherProvider,
) {
    suspend fun getBreeds() = withContext(dispatcherProvider.io) {
        api.getBreeds().breeds
    }
    suspend fun getBreedImage(breed: String) = withContext(dispatcherProvider.io) {
        api.getRandomBreedImageFor(breed).breedImageUrl
    }
}
