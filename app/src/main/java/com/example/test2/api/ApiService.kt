package com.example.test2.api

import com.example.test2.data.DataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/api/v2/publicholidays/2023/US")
    fun getPosts(): Call<MutableList<DataModel>>

}