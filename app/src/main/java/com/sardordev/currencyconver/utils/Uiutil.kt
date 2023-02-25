package com.sardordev.currencyconver.utils

sealed class Uiutil {


    data class Success<T>(val data: T?) : Uiutil()
    data class Error(val message: String) : Uiutil()



    object Loading : Uiutil()
    object  Empty : Uiutil()


}