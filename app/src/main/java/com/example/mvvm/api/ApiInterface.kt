package com.example.mvvm.api

import com.example.mvvm.model.Users
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/users")
    suspend fun getUsers(): Response<List<Users>>

}