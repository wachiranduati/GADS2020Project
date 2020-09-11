package com.example.gads2020.ui.netCalls.learners

import com.example.gads2020.ui.Data.tophours.TopHourLearners
import com.example.gads2020.ui.Data.topskill.TopSkillIQ
import retrofit2.http.GET

interface HerokuService {
    @GET("/api/hours")
    suspend fun retrieveTopHourLearners(): TopHourLearners

    @GET("/api/skilliq")
    suspend fun retrieveTopSkillIQLearners(): TopSkillIQ
}