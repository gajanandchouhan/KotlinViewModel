package com.example.gajanand.mvvmdemo.model

import android.arch.lifecycle.MutableLiveData
import android.widget.Toast
import com.example.gajanand.mvvmdemo.MvvmDemo
import com.example.gajanand.mvvmdemo.db.AppDataBase
import com.example.gajanand.mvvmdemo.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository{

    var heroList: MutableLiveData<List<Hero>>? = MutableLiveData()
    fun getHeros(): MutableLiveData<List<Hero>> {
            val apiService = ApiClient.getApiService();
            apiService.getHeroes().enqueue(object : Callback<List<Hero>> {
                override fun onFailure(call: Call<List<Hero>>?, t: Throwable?) {
                    Toast.makeText(MvvmDemo.getInstance(), "Something went wrong", Toast.LENGTH_LONG).show();
                }

                override fun onResponse(call: Call<List<Hero>>?, response: Response<List<Hero>>?) {

                    if (response != null) {
                        if (response.body() != null) {
                            Toast.makeText(MvvmDemo.getInstance(), "Success", Toast.LENGTH_LONG).show();
                            val heroDao = AppDataBase.getAppDatabase(MvvmDemo.getInstance()!!)!!.heroDao()
                            heroDao.insertAll(response.body()!!)
                            heroList!!.value = response.body()
                        }


                    }
                }

            })
        return heroList as MutableLiveData<List<Hero>>
    }
}