package com.example.gads2020.ui.netCalls

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface GoogleService {
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    suspend fun SubmitData(
        @Field("entry.1824927963") EmailAddress : String,
        @Field("entry.1877115667") Name : String,
        @Field("entry.2006916086") LastName : String,
        @Field("entry.284483984") LinkToProject : String
    )

}