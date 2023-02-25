package com.sardordev.currencyconver.domain.savefavoriteRepo

import androidx.lifecycle.LiveData
import com.sardordev.currencyconver.data.entity.FaviriteEntity
import kotlinx.coroutines.flow.Flow


interface SaveFavoriteRepository {
     fun saveData(faviriteEntity: FaviriteEntity)

     fun getData(): LiveData<List<FaviriteEntity>>

}