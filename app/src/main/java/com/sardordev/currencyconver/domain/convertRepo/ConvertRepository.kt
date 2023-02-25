package com.sardordev.currencyconver.domain.convertRepo

import com.sardordev.currencyconver.data.model.CurrencyModel
import com.sardordev.currencyconver.utils.SourseEvent


interface ConvertRepository {

   suspend fun getConvertList(): SourseEvent<List<CurrencyModel>>


}