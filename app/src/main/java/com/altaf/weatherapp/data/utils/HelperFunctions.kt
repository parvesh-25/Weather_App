package com.altaf.weatherapp.data.utils

import java.math.RoundingMode

object HelperFunctions {

    // mengganti satuan nya dari kelvin ke celcius
    fun formatterDegree(temperature: Double?): String{
         val maxTemp = temperature as Double
         val tempToCelsius = maxTemp - 273.0
         // toBigDecimal() = agar desimalnya maksimal 2 angka blkg koma , RoundingModen = dibulatkan
         val formatDegree = tempToCelsius.toBigDecimal().setScale(2, RoundingMode.CEILING).toDouble()
         return "$formatDegree °C"
    }
}