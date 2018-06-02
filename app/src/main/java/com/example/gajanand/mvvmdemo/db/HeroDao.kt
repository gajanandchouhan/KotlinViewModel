package com.example.gajanand.mvvmdemo.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.example.gajanand.mvvmdemo.model.Hero

@Dao
interface HeroDao {
    @Query("SELECT * from hero_tbl")
    fun getAllHeros(): List<Hero>


    @Insert(onConflict = REPLACE)
    fun insertAll(heros: List<Hero>)

    @Query("DELETE from hero_tbl")
    fun deleteAll()
}