package com.collect.invest.utils

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*

object HttpClientFactory {
    val client: HttpClient by lazy {
        HttpClient(CIO){
            install(ContentNegotiation) {
                json(contentType = ContentType.Any)
            }
        }
    }
}