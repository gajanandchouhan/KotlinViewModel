package com.example.gajanand.mvvmdemo.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.gajanand.mvvmdemo.model.Hero

@Database(entities = arrayOf(Hero::class), version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun heroDao(): HeroDao

    companion object {
        private var INSTANCE: AppDataBase? = null

        fun getAppDatabase(context: Context): AppDataBase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, AppDataBase::class.java, "hero-db")
                        // allow queries on the main thread.
                        // Don't do this on a real app! See PersistenceBasicSample for an example.
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}