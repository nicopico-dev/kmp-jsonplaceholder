package fr.nicopico.kmp.jsonplaceholder.di.modules

import de.jensklingenberg.ktorfit.Ktorfit
import fr.nicopico.kmp.jsonplaceholder.api.JSONPlaceholderApi
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import co.touchlab.kermit.Logger as KermitLogger

private const val HTTP_TIMEOUT = 30_000L

internal val apiModule = module {
    single<HttpClient> {
        HttpClient(get()) {
            expectSuccess = true
            install(ContentNegotiation) {
                json(
                    Json {
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }

            install(Logging) {
                val log = get<KermitLogger> { parametersOf("HTTP") }
                logger = object : Logger {
                    override fun log(message: String) {
                        log.v { message }
                    }
                }

                level = LogLevel.INFO
            }

            install(HttpTimeout) {
                connectTimeoutMillis = HTTP_TIMEOUT
                requestTimeoutMillis = HTTP_TIMEOUT
                socketTimeoutMillis = HTTP_TIMEOUT
            }
        }
    }

    single<Ktorfit.Builder> {
        Ktorfit.Builder()
            .httpClient(get<HttpClient>())
    }

    factory<JSONPlaceholderApi> {
        val ktorfit = get<Ktorfit.Builder>()
            .baseUrl(JSONPlaceholderApi.BASE_URL)
            .build()
        ktorfit.create()
    }
}
