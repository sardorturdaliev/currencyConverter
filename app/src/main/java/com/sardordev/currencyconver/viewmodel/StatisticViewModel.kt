package com.sardordev.currencyconver.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sardordev.currencyconver.domain.convertRepo.ConvertRepository
import com.sardordev.currencyconver.domain.savefavoriteRepo.SaveFavoriteRepository
import com.sardordev.currencyconver.utils.SourseEvent
import com.sardordev.currencyconver.utils.Uiutil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatisticViewModel @Inject constructor(private val repository: ConvertRepository) :
    ViewModel() {
    private val _converList = MutableStateFlow<Uiutil>(Uiutil.Empty)
    val converList: StateFlow<Uiutil> get() = _converList

    fun getCurrencyList() {
        viewModelScope.launch {
            _converList.value = Uiutil.Loading

            val result = repository.getConvertList()

            when (result) {
                is SourseEvent.Error -> {
                    _converList.value = Uiutil.Error(message = result.message!!)
                }
                is SourseEvent.Success -> {
                    _converList.value = Uiutil.Success(result.data)
                }
            }

        }
    }

}