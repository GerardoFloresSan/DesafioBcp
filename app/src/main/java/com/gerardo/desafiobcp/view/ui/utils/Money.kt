package com.gerardo.desafiobcp.view.ui.utils

import android.content.Context
import com.gerardo.desafiobcp.data.entity.MoneyEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object Money {
    private val TAG: String = "Money"

    private lateinit var list: MutableList<MoneyEntity>

    fun init(context: Context) {
        initJsonRead(context)
    }

    private fun initJsonRead(context: Context) {
        synchronized(this) {
            val stringBuilder: StringBuilder by lazy {
                context.assets.open("json/money.json").use {
                    val size = it.available()
                    val buffer = ByteArray(size)
                    it.read(buffer)
                    it.close()
                    val json = String(buffer, Charsets.UTF_8)

                    StringBuilder(json)
                }
            }

            val jsonAdapter by lazy {
                val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

                moshi.adapter<FeaturesJsonEntity>(FeaturesJsonEntity::class.java)
            }

            val featuresJsonEntity = jsonAdapter.fromJson(stringBuilder.toString())

            list = featuresJsonEntity?.currencies as MutableList<MoneyEntity>
        }
    }

    fun getAllMoney() : List<MoneyEntity> {
        val listTemp: MutableList<MoneyEntity> = arrayListOf()
        for(m in list) {
            if(m.abbreviationMoney != "PEN") listTemp.add(m)
        }
        return listTemp
    }

    fun getCurrency(abbreviationMoney : String) : MoneyEntity {
        lateinit var  moneyEntity : MoneyEntity
        for (m in list) {
            if (m.abbreviationMoney == abbreviationMoney) moneyEntity = m
        }
        return moneyEntity
    }

    data class FeaturesJsonEntity(val currencies: List<MoneyEntity>)
}