package com.example.test2.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {
    // Create a single instance of OkHttpClient for making HTTP requests
    private val client = OkHttpClient.Builder().build()

    // Create a single instance of Retrofit with the base URL and GsonConverterFactory
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://date.nager.at")
        .addConverterFactory(GsonConverterFactory.create()) // Convert JSON responses to objects
        .client(client) // Set the OkHttpClient for the Retrofit instance
        .build()

    // Function to build and return a service interface based on the provided class
    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}