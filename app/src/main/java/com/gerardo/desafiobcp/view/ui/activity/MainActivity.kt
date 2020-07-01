package com.gerardo.desafiobcp.view.ui.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.text.Editable
import android.widget.Toast
import com.gerardo.desafiobcp.R
import com.gerardo.desafiobcp.data.entity.MoneyEntity
import com.gerardo.desafiobcp.view.ui.base.BaseActivity
import com.gerardo.desafiobcp.view.ui.utils.Money
import com.gerardo.desafiobcp.view.ui.utils.SimpleTextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    lateinit var moneyBase : MoneyEntity
    lateinit var moneyBase2 : MoneyEntity

    override fun getView(): Int = R.layout.activity_main

    @SuppressLint("SetTextI18n")
    override fun onCreate() {
        super.onCreate()
        Thread.sleep(2000)
        moneyBase = Money.getCurrency("PEN")
        moneyBase2 = Money.getCurrency("USD")

        btnChangeIcon.tag = moneyBase
        btnChangeIconOut.tag = moneyBase2

        btnChangeIcon.text = moneyBase.moneyName
        btnChangeIconOut.text = moneyBase2.moneyName
        txtCompraYVenta.text = "Compra: ${moneyBase2.typeChangeBuy} | Venta: ${moneyBase2.typeChangeSale}"

        txtMoneyIn.addTextChangedListener(object : SimpleTextWatcher() {
            override fun afterTextChanged(s: Editable?) {
                if(!txtMoneyOut.isFocused && txtMoneyIn.isFocusable) {
                    when {
                        btnChangeIcon.tag == moneyBase2 && btnChangeIconOut.tag == moneyBase -> {
                            val newValue = if (txtMoneyIn.text.toString().trim()
                                    .isNotEmpty()
                            ) (txtMoneyIn.text.toString().trim()
                                .toDouble()) * moneyBase2.typeChangeBuy else ""// TIPO_CAMBIO_COMPRA_DOLAR
                            txtMoneyOut.setText(newValue.toString())
                        }
                        btnChangeIcon.tag == moneyBase && btnChangeIconOut.tag == moneyBase2 -> {
                            val newValue = if (txtMoneyIn.text.toString().trim()
                                    .isNotEmpty()
                            ) (txtMoneyIn.text.toString().trim()
                                .toDouble()) / moneyBase2.typeChangeSale else ""// TIPO_CAMBIO_VENTA_DOLAR
                            txtMoneyOut.setText(newValue.toString())
                        }
                        else -> {
                            Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_LONG)
                        }
                    }
                }

            }
        })

        txtMoneyOut.addTextChangedListener(object : SimpleTextWatcher() {
            override fun afterTextChanged(s: Editable?) {
                if(!txtMoneyIn.isFocused && txtMoneyOut.isFocused) {
                    when {
                        btnChangeIcon.tag == moneyBase2 && btnChangeIconOut.tag == moneyBase -> {
                            val newValue = if(txtMoneyOut.text.toString().trim().isNotEmpty()) (txtMoneyOut.text.toString().trim().toDouble()) / moneyBase2.typeChangeSale else ""// TIPO_CAMBIO_COMPRA_DOLAR
                            txtMoneyIn.setText(newValue.toString())
                        }
                        btnChangeIcon.tag == moneyBase && btnChangeIconOut.tag == moneyBase2 -> {
                            val newValue = if(txtMoneyOut.text.toString().trim().isNotEmpty()) (txtMoneyOut.text.toString().trim().toDouble()) * moneyBase2.typeChangeBuy else ""// TIPO_CAMBIO_VENTA_DOLAR
                            txtMoneyIn.setText(newValue.toString())
                        }
                        else -> {
                            Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_LONG)
                        }
                    }
                }
            }
        })

        changeMoneyValue()
        setClick()
    }

    override fun onResume() {
        super.onResume()
        txtCompraYVenta.text = "Compra: ${moneyBase2.typeChangeBuy} | Venta: ${moneyBase2.typeChangeSale}"
    }

    private fun changeMoneyValue() {
        moneyChange.setOnClickListener {
            val temporalSave = btnChangeIcon.tag as MoneyEntity
            val temporalSave2 = btnChangeIconOut.tag as MoneyEntity
            btnChangeIcon.tag = temporalSave2
            btnChangeIconOut.tag = temporalSave
            btnChangeIcon.text = temporalSave2.moneyName
            btnChangeIconOut.text = temporalSave.moneyName
            changedValues()
        }
    }

    private fun changedValues() {
        when {
            btnChangeIcon.tag == moneyBase2 && btnChangeIconOut.tag == moneyBase -> {
                val newValue = if(txtMoneyIn.text.toString().trim().isNotEmpty()) (txtMoneyIn.text.toString().trim().toDouble()) * moneyBase2.typeChangeBuy else ""// TIPO_CAMBIO_COMPRA_DOLAR
                txtMoneyOut.setText(newValue.toString())
            }
            btnChangeIcon.tag == moneyBase && btnChangeIconOut.tag == moneyBase2 -> {
                val newValue = if(txtMoneyIn.text.toString().trim().isNotEmpty()) (txtMoneyIn.text.toString().trim().toDouble()) / moneyBase2.typeChangeSale else ""// TIPO_CAMBIO_VENTA_DOLAR
                txtMoneyOut.setText(newValue.toString())
            }
            else -> {
                Toast.makeText(this, "Error", Toast.LENGTH_LONG)
            }
        }
    }

    private fun setClick() {
        btnChangeIcon.setOnClickListener {
            if ((it.tag as MoneyEntity) != moneyBase) openCurrencyFlag(0)
        }

        btnChangeIconOut.setOnClickListener {
            if ((it.tag as MoneyEntity) != moneyBase) openCurrencyFlag(1)
        }
    }

    private fun openCurrencyFlag(typeButton : Int) {
        startActivityForResult(Intent(this, FlagsActivity::class.java).apply {
            putExtra("extra0", typeButton)
        }, REQUEST_MONEY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (Activity.RESULT_OK == resultCode && REQUEST_MONEY == requestCode) {
            val typeButton = data?.getSerializableExtra("extra0") as Int
            val moneyEntity = data?.getSerializableExtra("extra1") as MoneyEntity
            moneyBase2 = moneyEntity
            if (typeButton == 0) {
                btnChangeIcon.tag = moneyBase2
                btnChangeIconOut.tag = moneyBase
                btnChangeIcon.text = moneyBase2.moneyName
                btnChangeIconOut.text = moneyBase.moneyName
            }
            if (typeButton == 1) {
                btnChangeIcon.tag = moneyBase
                btnChangeIconOut.tag = moneyBase2
                btnChangeIcon.text = moneyBase.moneyName
                btnChangeIconOut.text = moneyBase2.moneyName
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    companion object {
        private const val REQUEST_MONEY = 2863
    }
}