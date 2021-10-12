package com.example.exampleretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exampleretrofit.retrofit.WeatherResponse
import com.example.exampleretrofit.retrofit.WeatherRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun getCurrentWeather(id: Int) {
        WeatherRetrofit.createWeatherApi().getCurrentWeather(cityId = id)
            .enqueue(object : Callback<WeatherResponse>{
                override fun onResponse(p0: Call<WeatherResponse>, p1: Response<WeatherResponse>) {

                }

                override fun onFailure(p0: Call<WeatherResponse>, p1: Throwable) {

                }
            })

    }
}