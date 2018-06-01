package com.example.gajanand.mvvmdemo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        fun getApiService(): ApiService {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://simplifiedcoding.net/demos/")
                    .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}