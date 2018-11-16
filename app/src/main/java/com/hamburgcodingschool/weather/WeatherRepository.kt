package com.hamburgcodingschool.weather

import com.hamburgcodingschool.weather.model.City

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Teresa Holfeld, teresa.holfeld@gmail.com
 */
open class WeatherRepository(private val apiKey: String) {

    private val service: WeatherService
    private var callback: WeatherCallback? = null

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        service = retrofit.create(WeatherService::class.java)
    }

    fun setCallback(callback: WeatherCallback) {
        this.callback = callback
    }

    open fun getWeather(city: String) {
        val cityCall = service.getWeather(city, apiKey)
        cityCall.enqueue(object : Callback<City> {
            override fun onResponse(call: Call<City>, response: Response<City>) {
                val city = response.body()
                callback!!.receiveWeather(city)
            }

            override fun onFailure(call: Call<City>, t: Throwable) {
                callback!!.receiveWeather(null)
            }
        })
    }

    interface WeatherCallback {

        fun receiveWeather(city: City?)
    }

    companion object {

        private val BASE_URL = "https://api.openweathermap.org"
    }
}
