package com.sardordev.currencyconver.utils

sealed class SourseEvent<T>(data: T?, message: String? = null) {

    data class Success<T>(val data: T?) : SourseEvent<T>(data)
    data class Error<T>(val data: T? = null, val message: String?) : SourseEvent<T>(data, message)

}