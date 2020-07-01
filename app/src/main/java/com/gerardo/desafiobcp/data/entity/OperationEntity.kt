package com.gerardo.desafiobcp.data.entity

import com.squareup.moshi.Json
import java.io.Serializable

data class OperationEntity(
    @Json(name = "NUMBER_OPERATION") var numberOperation: String = "",
    @Json(name = "MONEY_IN") var moneyIn: Double = 0.0,
    @Json(name = "MONEY_OUT") var moneyOut: Double = 0.0,
    @Json(name = "ABBREVIATION_MONEY_OUT") var abbreviationMoneyOut: String = "",
    @Json(name = "ABBREVIATION_MONEY_IN") var abbreviationMoneyIn: String = ""
) : Serializable {
    override fun toString(): String {
        return "OperationEntity(numberOperation='$numberOperation'," +
                "moneyIn='$moneyIn'," +
                "moneyOut='$moneyOut'," +
                "abbreviationMoneyOut='$abbreviationMoneyOut'," +
                "abbreviationMoneyIn='$abbreviationMoneyIn')"
    }
}