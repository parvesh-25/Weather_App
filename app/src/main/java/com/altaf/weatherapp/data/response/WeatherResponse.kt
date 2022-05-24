package com.altaf.weatherapp.data

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("coord")
    val coordinate: Coord? = null,

    @field:SerializedName("weather")
    val weather: List<WeatherItem>? = null,

    @field:SerializedName("main")
    val main:Main? = null


)

data class Coord(
    @field:SerializedName("lon")
    val lon : Double? = null,

    @field:SerializedName("lat")
    val lat : Double? = null
)

data class WeatherItem(
    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("main")
    val main: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("icon")
    val icon: String? = null,

)
