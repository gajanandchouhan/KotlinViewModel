package com.example.gajanand.mvvmdemo.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.gajanand.mvvmdemo.R
import com.example.gajanand.mvvmdemo.adapter.HeroAdapter
import com.example.gajanand.mvvmdemo.databinding.ActivityMainBinding
import com.example.gajanand.mvvmdemo.db.AppDataBase
import com.example.gajanand.mvvmdemo.model.Hero
import com.example.gajanand.mvvmdemo.viewmodel.HeroesViewModel

class MainActivity : Observer<List<Hero>>, AppCompatActivity() {
    var recyclerView: RecyclerView? = null


    var conetView: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        conetView = DataBindingUtil.setContentView(this, R.layout.activity_main)
        recyclerView = conetView?.recyclerView as RecyclerView;
        recyclerView?.layoutManager = LinearLayoutManager(this)
        val heroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)
        heroesViewModel.geteHeros()!!.observe(this, this)
    }


    override fun onChanged(heroList: List<Hero>?) {
        if (heroList != null) {
            //val allHeros = AppDataBase.getAppDatabase(this@MainActivity)!!.heroDao().getAllHeros()
            if (recyclerView != null) {
                recyclerView!!.adapter = HeroAdapter(heroList, this@MainActivity)
            }
        }
    }
}
