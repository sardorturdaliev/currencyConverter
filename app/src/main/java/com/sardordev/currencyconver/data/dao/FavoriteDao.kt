package com.sardordev.currencyconver.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sardordev.currencyconver.data.entity.FaviriteEntity
import com.sardordev.currencyconver.utils.constants.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Insert
     fun insertData(faviriteEntity: FaviriteEntity)


    @Query("select * from ${Constants.FAVORITETABLE}")
     fun getAllData(): LiveData<List<FaviriteEntity>>



}