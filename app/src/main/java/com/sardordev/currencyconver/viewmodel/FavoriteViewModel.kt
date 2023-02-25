package com.sardordev.currencyconver.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sardordev.currencyconver.data.entity.FaviriteEntity
import com.sardordev.currencyconver.domain.savefavoriteRepo.SaveFavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class FavoriteViewModel @Inject constructor(private val saveFavoriteRepository: SaveFavoriteRepository) :
    ViewModel() {
     val allSavedCurrency: LiveData<List<FaviriteEntity>> = saveFavoriteRepository.getData()



}