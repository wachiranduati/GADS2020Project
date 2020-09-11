package com.example.gads2020.ui.netCalls.learners

import com.example.gads2020.ui.Data.tophours.TopHourLearners
import com.example.gads2020.ui.Data.topskill.TopSkillIQ
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LearnersRepoRetriever {
    private val service: HerokuService

    companion object {
        //1
        const val BASE_URL = "https://gadsapi.herokuapp.com/"
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
        service = retrofit.create(HerokuService::class.java)
    }

    suspend fun getTopHourLearners(): TopHourLearners  {
        return service.retrieveTopHourLearners()
    }

    suspend fun getTopIQLearners(): TopSkillIQ  {
        return service.retrieveTopSkillIQLearners()
    }

}