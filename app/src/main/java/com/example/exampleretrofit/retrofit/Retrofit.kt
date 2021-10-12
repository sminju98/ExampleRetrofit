package com.example.exampleretrofit.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object WeatherRetrofit {

    fun createWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

}

interface WeatherApi {

    companion object {
        private const val WEATHER_BY_ID = "data/2.5/weather"
        private const val APP_KEY = "a07cb097858e46d4e01fbb55f39849d6"

    }

    @GET(WEATHER_BY_ID)
    fun getCurrentWeather(
        @Query("id") cityId: Int,
        @Query("appid") appId: String = APP_KEY
    ) : call<WeatherResponse>
}