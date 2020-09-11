package com.example.gads2020.ui.netCalls

import com.example.gads2020.ui.Data.tophours.TopHourLearners
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryRetriever {
    private val service: GoogleService

    companion object {
        //1
        const val BASE_URL = "https://docs.google.com/forms/d/e/"
    }

    init {
        // 2
        val retrofit = Retrofit.Builder()
            // 1
            .baseUrl(BASE_URL)
            //3
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //4
        service = retrofit.create(GoogleService::class.java)
    }

    suspend fun submitData(email: String, name : String, lastname: String, linktoProject : String) {
        service.SubmitData(email, name, lastname, linktoProject)
    }

}