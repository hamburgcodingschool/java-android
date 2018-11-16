package com.hamburgcodingschool.weather

import com.hamburgcodingschool.weather.model.City

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Teresa Holfeld, teresa.holfeld@gmail.com
 */
interface WeatherService {

    @GET("/data/2.5/weather")
    fun getWeather(@Query("q") city: String, @Query("appid") apiKey: String): Call<City>

}
