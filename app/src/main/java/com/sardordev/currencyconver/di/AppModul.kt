package com.sardordev.currencyconver.di

import com.sardordev.currencyconver.data.api.ConvertApi
import com.sardordev.currencyconver.data.db.DatabaseFavorite
import com.sardordev.currencyconver.domain.convertRepo.ConvertRepository
import com.sardordev.currencyconver.domain.convertRepo.ConvertRepositoryImp
import com.sardordev.currencyconver.domain.savefavoriteRepo.SaveFavoriteRepository
import com.sardordev.currencyconver.domain.savefavoriteRepo.SaveFavoriteRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModul {

    @Singleton
    @Provides
    fun getCurrencyApi(): ConvertApi {
        return Retrofit.Builder()
            .baseUrl("https://cbu.uz/uz/arkhiv-kursov-valyut/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ConvertApi::class.java)
    }

    @Singleton
    @Provides
    fun getRepositoryConvert(api: ConvertApi): ConvertRepository = ConvertRepositoryImp(api)

    @Singleton
    @Provides
    fun getDatabase(): DatabaseFavorite {
        return DatabaseFavorite.getInstance()
    }

    @Singleton
    @Provides
    fun getFavoriteRepository(databaseFavorite: DatabaseFavorite): SaveFavoriteRepository =
        SaveFavoriteRepositoryImp(databaseFavorite)


}