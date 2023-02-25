package com.sardordev.currencyconver.data.api

import com.sardordev.currencyconver.data.model.CurrencyModel
import retrofit2.Response
import retrofit2.http.GET

interface ConvertApi {


    @GET("json")
    suspend fun getValyut(): Response<List<CurrencyModel>>


}