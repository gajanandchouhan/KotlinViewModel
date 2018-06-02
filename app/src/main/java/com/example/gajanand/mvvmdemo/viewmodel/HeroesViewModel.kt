package com.example.gajanand.mvvmdemo.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.widget.Toast
import com.example.gajanand.mvvmdemo.MvvmDemo
import com.example.gajanand.mvvmdemo.model.Hero
import com.example.gajanand.mvvmdemo.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroesViewModel : ViewModel() {
    var heroList: MutableLiveData<List<Hero>>? = null

    fun getHeros(): MutableLiveData<List<Hero>> {
        if (heroList == null) {
            heroList = MutableLiveData()
            val apiService = ApiClient.getApiService();
            apiService.getHeroes().enqueue(object : Callback<List<Hero>> {
                override fun onFailure(call: Call<List<Hero>>?, t: Throwable?) {
                    Toast.makeText(MvvmDemo.getInstance(), "Something went wrong", Toast.LENGTH_LONG).show();
                }

                override fun onResponse(call: Call<List<Hero>>?, response: Response<List<Hero>>?) {

                    if (response != null) {
                        heroList!!.value=response.body()
                        Toast.makeText(MvvmDemo.getInstance(), "Success", Toast.LENGTH_LONG).show();
                    }
                }

            })
        }
        return heroList as MutableLiveData<List<Hero>>
    }
}