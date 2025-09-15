package com.dhanu.trailproject.trailapi

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object ApiClient {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com"


    private val httpClient = HttpClient {
        install(ContentNegotiation){
            json(Json { ignoreUnknownKeys = true })
        }

    }


    suspend fun getPost(): List<Post> {
        return httpClient.get("$BASE_URL/posts").body()
    }
}