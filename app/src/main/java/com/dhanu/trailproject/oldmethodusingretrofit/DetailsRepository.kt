package com.dhanu.trailproject.oldmethodusingretrofit

class DetailsRepository {

    suspend fun fetchDetails(): List<OldMDetails>{
        return RetrofitInstance.apiService.getDetails()
    }
}