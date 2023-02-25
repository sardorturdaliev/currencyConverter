package com.sardordev.currencyconver.utils

import com.sardordev.currencyconver.data.model.CurrencyModel

interface ClickItemListener {


    fun click(currencyModel: CurrencyModel)

    fun clickFavorite(currencyModel: CurrencyModel)

}