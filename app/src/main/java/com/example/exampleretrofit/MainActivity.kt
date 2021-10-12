package com.example.exampleretrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.exampleretrofit.retrofit.WeatherResponse
import com.example.exampleretrofit.retrofit.WeatherRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getCurrentWeather(707860)

    }

    private fun getCurrentWeather(id: Int) {
        WeatherRetrofit.createWeatherApi().getCurrentWeather(id = id)
            .enqueue(object : Callback<WeatherResponse> {
                override fun onResponse(
                    p0: Call<WeatherResponse>,
                    response: Response<WeatherResponse>
                ) {

                    response.body()?.let {
                        Log.d("결과", it.name)
                    }
                }

                override fun onFailure(p0: Call<WeatherResponse>, p1: Throwable) {
                    Log.d("결과", p1.message ?: "에러")
                }
            })

    }
}