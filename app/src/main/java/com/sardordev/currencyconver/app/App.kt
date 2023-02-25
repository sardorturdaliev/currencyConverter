package com.sardordev.currencyconver.app

import android.app.Application
import com.sardordev.currencyconver.data.db.DatabaseFavorite
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        DatabaseFavorite.init(this)
    }
}