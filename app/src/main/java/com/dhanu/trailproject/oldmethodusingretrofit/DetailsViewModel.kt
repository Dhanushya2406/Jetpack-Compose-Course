package com.dhanu.trailproject.oldmethodusingretrofit

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DetailsViewModel: ViewModel() {

    private val repository = DetailsRepository()

    var details = mutableStateListOf<OldMDetails>()
        private set


    fun fetchDetails(){
        viewModelScope.launch {
            try {
                val response = repository.fetchDetails()
                details.clear()
                details.addAll(response)
            }catch (e: Exception){
                Log.e("Retrofit Error", "Error: ${e.message}")
                details.addAll(emptyList())
            }

        }
    }

}