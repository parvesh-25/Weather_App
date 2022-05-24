package com.altaf.weatherapp.data.network


import com.altaf.weatherapp.BuildConfig
import com.altaf.weatherapp.data.ForecastResponse
import com.altaf.weatherapp.data.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("weather")
    // utk mengambil data dan mengembalikan ke response
    fun weatherByCity(
        // parameter q dari API call
        @Query("q") city: String,
        // param appid
        @Query("appid") apiKey: String? = BuildConfig.API_KEY
    // mengembalikan nilai retrofit
    ) : Call<WeatherResponse>

    @GET("forecast")
    fun forecastByCity(
        @Query("q") city: String,
        @Query("appid") apiKey: String? = BuildConfig.API_KEY
    ) : Call<ForecastResponse>

    @GET("weather")
    fun weatherByCurrentLocation(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String? = BuildConfig.API_KEY
    ): Call<WeatherResponse>

    @GET("weather")
    fun forecastByCurrentLocation(
       @Query("lat") lat: Double,
       @Query("lon") lon: Double,
       @Query("appid") apiKey: String? = BuildConfig.API_KEY
    ) : Call<ForecastResponse>
}