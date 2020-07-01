package com.gerardo.desafiobcp.view.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gerardo.desafiobcp.R
import com.gerardo.desafiobcp.view.ui.utils.ChangeMoney
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var operation: ChangeMoney

    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUI()
        changeMoneyValue()
        calculoDeArriba()
        calculoDeAbajo()
    }

    private fun setUI() {
        txtCompraYVenta.text = "Compra: $TIPO_CAMBIO_COMPRA_DOLAR | Venta: $TIPO_CAMBIO_VENTA_DOLAR"
    }

    private fun changeMoneyValue() {

        /*
        txtMoneyOut.addTextChangedListener(object : SimpleTextWatcher() {
            override fun afterTextChanged(s: Editable?) {
                val nuevoValor = (txtMoneyIn.text.toString().trim().toDouble()) * 3.29
                Log.wtf("VENTA", "VALOR ANTIGUO$nuevoValor")
                txtMoneyIn.setText(nuevoValor.toString())
            }
        })

        txtMoneyIn.addTextChangedListener(object : SimpleTextWatcher() {
            override fun afterTextChanged(s: Editable?) {
                val nuevoValor = (txtMoneyIn.text.toString().trim().toDouble()) * 3.25
                Log.wtf("COMPRA", "VALOR ANTIGUO$nuevoValor")
                txtMoneyOut.setText(nuevoValor.toString())

            }
        })*/

        moneyChange.setOnClickListener {
            if (btnChangeIcon.text == DOLARES && btnChangeIconOut.text == SOLES) {
                Thread.sleep(100)
                btnChangeIcon.text = "Soles"
                btnChangeIconOut.text = "Dolares"
                circuloCambioDeValores()
            } else {
                Thread.sleep(100)
                btnChangeIcon.text = "Dolares"
                btnChangeIconOut.text = "Soles"
                circuloCambioDeValores()
            }
        }

    }

    fun circuloCambioDeValores() {
        if (btnChangeIcon.text == DOLARES && btnChangeIconOut.text == SOLES) {
            val nuevoValor =
                (txtMoneyIn.text.toString().trim().toDouble()) * TIPO_CAMBIO_COMPRA_DOLAR
            txtMoneyOut.setText(nuevoValor.toString())
        } else if (btnChangeIcon.text == SOLES && btnChangeIconOut.text == DOLARES) {
            val nuevoValor =
                (txtMoneyIn.text.toString().trim().toDouble()) / TIPO_CAMBIO_VENTA_DOLAR
            txtMoneyOut.setText(nuevoValor.toString())
        }
    }

    private fun calculoDeArriba() {
        btnOperationChange.setOnClickListener {
            if (btnChangeIcon.text == DOLARES && btnChangeIconOut.text == SOLES) {
                val nuevoValor =
                    (txtMoneyOut.text.toString().trim().toDouble()) / TIPO_CAMBIO_COMPRA_DOLAR
                txtMoneyIn.setText(nuevoValor.toString())
            } else {
                val nuevoValor =
                    (txtMoneyOut.text.toString().trim().toDouble()) * TIPO_CAMBIO_VENTA_DOLAR
                txtMoneyIn.setText(nuevoValor.toString())
            }
        }
    }

    private fun calculoDeAbajo() {
        btnOperationChange2.setOnClickListener {
            if (btnChangeIcon.text == DOLARES && btnChangeIconOut.text == SOLES) {
                val nuevoValor =
                    (txtMoneyIn.text.toString().trim().toDouble()) * TIPO_CAMBIO_COMPRA_DOLAR
                txtMoneyOut.setText(nuevoValor.toString())
            } else {
                val nuevoValor =
                    (txtMoneyIn.text.toString().trim().toDouble()) / TIPO_CAMBIO_VENTA_DOLAR
                txtMoneyOut.setText(nuevoValor.toString())
            }
        }
    }

    private fun redirectToFlags() {
        val nextActivity = Intent(this, FlagsActivity::class.java)
        startActivity(nextActivity)
    }

    companion object {

        //Dolar
        private const val TIPO_CAMBIO_VENTA_DOLAR = 3.29
        private const val TIPO_CAMBIO_COMPRA_DOLAR = 3.25
        //Euros
        private const val TIPO_CAMBIO_VENTA_EURO= 4.10
        private const val TIPO_CAMBIO_COMPRA_EURO = 4.20
        //Libras
        private const val TIPO_CAMBIO_VENTA_LIBRA= 5.00
        private const val TIPO_CAMBIO_COMPRA_LIBRA = 5.50
        //Yen
        private const val TIPO_CAMBIO_VENTA_YEN= 5.00
        private const val TIPO_CAMBIO_COMPRA_YEN = 5.50
        //Dolar Canadiense
        private const val TIPO_CAMBIO_VENTA_DOLAR_CANADIENSE= 2.29
        private const val TIPO_CAMBIO_COMPRA_DOLAR_CANADIENSE = 2.50
        //Franco Suizo
        private const val TIPO_CAMBIO_VENTA_FRANCO_SUIZO= 2.29
        private const val TIPO_CAMBIO_COMPRA_FRANCO_SUIZO = 2.50


        private const val SOLES = "Soles"
        private const val DOLARES = "Dolares"
        private const val EURO = "E"
        private const val YEN = "Y"
        private const val LIBRA = "L"
        private const val DOLAR_CANADIENSE = "DC"
        private const val FRANCO_SUIZO = "FS"

    }
}
