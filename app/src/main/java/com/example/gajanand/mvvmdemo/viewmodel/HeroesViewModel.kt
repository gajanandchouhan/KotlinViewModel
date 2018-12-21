package com.example.gajanand.mvvmdemo.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.widget.Toast
import com.example.gajanand.mvvmdemo.MvvmDemo
import com.example.gajanand.mvvmdemo.db.AppDataBase
import com.example.gajanand.mvvmdemo.model.Hero
import com.example.gajanand.mvvmdemo.model.Repository
import com.example.gajanand.mvvmdemo.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroesViewModel : ViewModel() {

    fun geteHeros(): MutableLiveData<List<Hero>>? {
        return Repository().getHeros()
    }

}