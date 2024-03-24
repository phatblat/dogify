package at.phatbl.dogify.api

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Internal prevents Kotlin/Native compiler from adding generated code to add to the output binary.
 * https://github.com/PacktPublishing/Simplifying-Application-Development-with-Kotlin-Multiplatform-Mobile/blob/4f820abbef327a53b702f92f2e346fa86b89f36d/shared/src/commonMain/kotlin/com/nagyrobi144/dogify/api/KtorApi.kt#L12
 */
internal abstract class KtorApi {
    private val jsonConfiguration = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
    }
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }
    }
}
