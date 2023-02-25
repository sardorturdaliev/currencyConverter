package com.sardordev.currencyconver.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sardordev.currencyconver.utils.constants.Constants

@Entity(tableName = "${Constants.FAVORITETABLE}")
data class FaviriteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "currencycol")
    val currencyName: String,
    @ColumnInfo(name = "currencyPricecol")
    val currencyPrice: String,
    @ColumnInfo(name = "currencyTranscol")
    val currencyTranslated: String
)