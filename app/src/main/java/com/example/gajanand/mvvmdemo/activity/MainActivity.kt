package com.example.gajanand.mvvmdemo.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.gajanand.mvvmdemo.GlideApp
import com.example.gajanand.mvvmdemo.R
import com.example.gajanand.mvvmdemo.model.Hero
import com.example.gajanand.mvvmdemo.viewmodel.HeroesViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val heroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)
        heroesViewModel.getHeros().observe(this, object : Observer<List<Hero>> {
            override fun onChanged(heroList: List<Hero>?) {
                if (heroList != null) {
                    for (hero in heroList) {
                        System.out.println(hero.name + ", " + hero.imageurl)
                    }
                }
            }

        })
    }
}
