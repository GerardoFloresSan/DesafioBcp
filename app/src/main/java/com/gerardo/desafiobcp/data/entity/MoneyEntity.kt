package com.gerardo.desafiobcp.data.entity

import com.squareup.moshi.Json
import java.io.Serializable

data class MoneyEntity (
    @Json(name = "MONEY_NAME_COUNTRY") var moneyNameCountry: String = "",
    @Json(name = "MONEY_NAME") var moneyName: String = "",
    @Json(name = "TYPE_CHANGE_SALE") var typeChangeSale: Double = 0.0,
    @Json(name = "TYPE_CHANGE_BUY") var typeChangeBuy: Double = 0.0,
    @Json(name = "ABBREVIATION_MONEY") var abbreviationMoney: String = "",
    @Json(name = "URL_FLAG") var urlFlag: String = "",
    @Json(name = "FACTOR_MONEY") var factoryMoney: String = ""
) : Serializable {
    override fun toString(): String {
        return "MoneyEntity(moneyNameCountry='$moneyNameCountry'," +
                "moneyName='$moneyName', " +
                "typeChangeSale='$typeChangeSale', " +
                "typeChangeBuy='$typeChangeBuy', " +
                "abbreviationMoney='$abbreviationMoney', " +
                "urlFlag='$urlFlag'," +
                "factoryMoney='$factoryMoney')"
    }
}