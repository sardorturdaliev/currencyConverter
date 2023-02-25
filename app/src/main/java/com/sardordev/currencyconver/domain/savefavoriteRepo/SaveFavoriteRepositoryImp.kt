package com.sardordev.currencyconver.domain.savefavoriteRepo

import androidx.lifecycle.LiveData
import androidx.room.RoomDatabase
import com.sardordev.currencyconver.data.db.DatabaseFavorite
import com.sardordev.currencyconver.data.entity.FaviriteEntity
import kotlinx.coroutines.flow.Flow

class SaveFavoriteRepositoryImp  constructor(private val database: DatabaseFavorite) :
    SaveFavoriteRepository {

    override  fun saveData(faviriteEntity: FaviriteEntity) {
        database.getFavoriteDao().insertData(faviriteEntity)
    }

    override  fun getData(): LiveData<List<FaviriteEntity>> =
        database.getFavoriteDao().getAllData()
}