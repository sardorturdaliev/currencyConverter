package com.sardordev.currencyconver.domain.convertRepo

import com.sardordev.currencyconver.data.api.ConvertApi
import com.sardordev.currencyconver.data.model.CurrencyModel
import com.sardordev.currencyconver.utils.SourseEvent
import javax.inject.Inject

class ConvertRepositoryImp @Inject constructor(private val api: ConvertApi) : ConvertRepository {

    override suspend fun getConvertList(): SourseEvent<List<CurrencyModel>> {
        return try {
            val result = api.getValyut()
            if (result.isSuccessful) {
                SourseEvent.Success(result.body())
            } else {
                SourseEvent.Error(message = result.message())
            }
        } catch (e: Exception) {
            SourseEvent.Error(message = e.message)
        }
    }


}