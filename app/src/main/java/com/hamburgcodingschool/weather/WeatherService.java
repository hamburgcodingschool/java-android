package com.hamburgcodingschool.weather;

import com.hamburgcodingschool.weather.model.City;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Teresa Holfeld, teresa.holfeld@gmail.com
 */
public interface WeatherService {
    @GET("/data/2.5/weather")
    Call<City> getWeather(@Query("q") String city, @Query("appid") String apiKey);
}
