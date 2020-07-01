package com.gerardo.desafiobcp.view.ui.utils

class ChangeMoney {

    // todo  >--- EL TIPO DE CAMBIO DE COMPRA ES MENOR QUE EL DE VENTA <---

    // TODO SI VOY CON DOLARES ES QUE VOY A VENDER <------ VENTA
    fun dolaresToSoles(cantidad: Double): Double {
        return cantidad * DOLARES_VENTA
    }

    // TODO SI VOY CON SOLES ES QUE VOY A COMPRANDO <----- COMPRAAA!
    fun solesToDolares(cantidad: Double): Double {
        return cantidad / DOLARES_COMPRA
    }


    companion object {
        private const val DOLARES_COMPRA = 3.25
        private const val DOLARES_VENTA = 3.29
        private const val EUROPEAN_UNION = 4.50
        private const val JAPAN = 5.00
    }
}