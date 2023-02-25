package com.sardordev.currencyconver.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sardordev.currencyconver.data.dao.FavoriteDao
import com.sardordev.currencyconver.data.entity.FaviriteEntity

@Database(entities = [FaviriteEntity::class], version = 1)
abstract class DatabaseFavorite : RoomDatabase() {
    abstract fun getFavoriteDao(): FavoriteDao

    companion object {
        private var instance: DatabaseFavorite? = null

        fun init(context: Context) {
            if (instance == null) {
                instance = Room.databaseBuilder(context, DatabaseFavorite::class.java, "mydb")
                    .allowMainThreadQueries().build()
            }
        }

        fun getInstance(): DatabaseFavorite = instance!!
    }


}