package com.dhanu.trailproject.oldmethodusingretrofit

import retrofit2.http.GET

interface ApiService {

    @GET("comments")
    suspend fun getDetails(): List<OldMDetails>
}