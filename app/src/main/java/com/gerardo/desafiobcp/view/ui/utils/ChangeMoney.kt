package com.gerardo.desafiobcp.view.ui.utils

class ChangeMoney {

    // todo  >--- EL TIPO DE CAMBIO DE COMPRA ES MENOR QUE EL DE VENTA <---

    fun dolaresToSoles(cantidad: Double): Double {
        return cantidad * TIPO_CAMBIO_VENTA_DOLAR
    }

    fun solesToDolares(cantidad: Double): Double {
        return cantidad / TIPO_CAMBIO_COMPRA_DOLAR
    }

    fun euroToSoles(cantidad: Double): Double {
        return cantidad * TIPO_CAMBIO_VENTA_EURO
    }

    fun solesToEuro(cantidad: Double): Double {
        return cantidad / TIPO_CAMBIO_COMPRA_EURO
    }

    fun librasToSoles(cantidad: Double): Double {
        return cantidad * TIPO_CAMBIO_VENTA_LIBRA
    }

    fun solesToLibras(cantidad: Double): Double {
        return cantidad / TIPO_CAMBIO_COMPRA_LIBRA
    }

    fun yenToSoles(cantidad: Double): Double {
        return cantidad * TIPO_CAMBIO_VENTA_YEN
    }

    fun solesToYen(cantidad: Double): Double {
        return cantidad / TIPO_CAMBIO_COMPRA_YEN
    }

    fun dolarCanadienseToSoles(cantidad: Double): Double {
        return cantidad * TIPO_CAMBIO_VENTA_DOLAR_CANADIENSE
    }

    fun solesToDolarCanadiense(cantidad: Double): Double {
        return cantidad / TIPO_CAMBIO_COMPRA_DOLAR_CANADIENSE
    }

    fun francoSuizoToSoles(cantidad: Double): Double {
        return cantidad * TIPO_CAMBIO_VENTA_FRANCO_SUIZO
    }

    fun solesToFrancoSuizo(cantidad: Double) : Double{
        return cantidad / TIPO_CAMBIO_COMPRA_FRANCO_SUIZO
    }

    companion object {

        //Dolar
        private const val TIPO_CAMBIO_VENTA_DOLAR = 3.29
        private const val TIPO_CAMBIO_COMPRA_DOLAR = 3.25

        //Euros
        private const val TIPO_CAMBIO_VENTA_EURO = 4.20
        private const val TIPO_CAMBIO_COMPRA_EURO = 4.10

        //Libras
        private const val TIPO_CAMBIO_VENTA_LIBRA = 5.50
        private const val TIPO_CAMBIO_COMPRA_LIBRA = 5.10

        //Yen
        private const val TIPO_CAMBIO_VENTA_YEN = 5.50
        private const val TIPO_CAMBIO_COMPRA_YEN = 5.10

        //Dolar Canadiense
        private const val TIPO_CAMBIO_VENTA_DOLAR_CANADIENSE = 2.59
        private const val TIPO_CAMBIO_COMPRA_DOLAR_CANADIENSE = 2.20

        //Franco Suizo
        private const val TIPO_CAMBIO_VENTA_FRANCO_SUIZO = 2.50
        private const val TIPO_CAMBIO_COMPRA_FRANCO_SUIZO = 2.29

        private const val SOLES = "Soles"
        private const val DOLARES = "Dolares"
        private const val EUROS = "Euros"
        private const val LIBRAS = "Libras"
        private const val YENES = "Yenes"
        private const val DOLAR_CANADIENSE = "Dolar Canadiense"
        private const val FRANCO_SUIZO = "Franco Suizo"

    }
}