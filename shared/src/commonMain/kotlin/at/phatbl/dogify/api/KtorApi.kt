package at.phatbl.dogify.api

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel.ALL
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.http.Url
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Internal prevents Kotlin/Native compiler from adding generated code to add to the output binary.
 * https://github.com/PacktPublishing/Simplifying-Application-Development-with-Kotlin-Multiplatform-Mobile/blob/4f820abbef327a53b702f92f2e346fa86b89f36d/shared/src/commonMain/kotlin/com/nagyrobi144/dogify/api/KtorApi.kt#L12
 */
internal abstract class KtorApi {
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                ignoreUnknownKeys = true
                isLenient = true
                useAlternativeNames = false
            })
        }
        install(Logging) {
            logger = Logger.SIMPLE
            level = ALL
        }
    }

    /** Use this method for configuring the request url */
    fun HttpRequestBuilder.apiUrl(path: String) {
        url {
            takeFrom(Url("https://dog.ceo"))
            path("api", path)
        }
    }
}

