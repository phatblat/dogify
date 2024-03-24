package at.phatbl.dogify.api

import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

internal class BreedsApi : KtorApi() {
    suspend fun getBreeds(): HttpResponse =
        client.get {
            apiUrl("breeds/list")
        }
    suspend fun getRandomBreedImageFor(breed: String): HttpResponse =
        client.get {
            apiUrl("breed/$breed/images/random")
        }
}
