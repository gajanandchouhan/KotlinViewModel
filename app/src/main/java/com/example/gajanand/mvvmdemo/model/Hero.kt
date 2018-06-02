package com.example.gajanand.mvvmdemo.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "hero_tbl")
data class Hero(@ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Long, @ColumnInfo(name = "name") val name: String, @ColumnInfo(name = "real_name") val realname: String, @ColumnInfo(name = "image") val imageurl: String)