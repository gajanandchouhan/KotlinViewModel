package com.example.gajanand.mvvmdemo.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.gajanand.mvvmdemo.R
import com.example.gajanand.mvvmdemo.adapter.HeroAdapter
import com.example.gajanand.mvvmdemo.databinding.ActivityMainBinding
import com.example.gajanand.mvvmdemo.db.AppDataBase
import com.example.gajanand.mvvmdemo.model.Hero
import com.example.gajanand.mvvmdemo.viewmodel.HeroesViewModel

class MainActivity : AppCompatActivity() {
    var conetView: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        conetView = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val recyclerView = conetView?.recyclerView
        recyclerView?.layoutManager= LinearLayoutManager(this)
        val heroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)
        heroesViewModel.getHeros().observe(this, object : Observer<List<Hero>> {
            override fun onChanged(heroList: List<Hero>?) {
                if (heroList != null) {
                    val allHeros = AppDataBase.getAppDatabase(this@MainActivity)!!.heroDao().getAllHeros()
                    if (recyclerView != null) {
                        recyclerView.adapter=HeroAdapter(allHeros,this@MainActivity)
                    }
                    for (allHeros in allHeros) {
                        System.out.println(allHeros.name + ", " + allHeros.imageurl)
                    }
                }
            }

        })
    }
}
