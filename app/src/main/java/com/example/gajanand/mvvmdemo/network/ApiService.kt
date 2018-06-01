package com.example.gajanand.mvvmdemo.network

import com.example.gajanand.mvvmdemo.model.Hero
import retrofit2.Call
import retrofit2.http.GET



interface ApiService {
    @GET("marvel")
    fun getHeroes(): Call<List<Hero>>
}