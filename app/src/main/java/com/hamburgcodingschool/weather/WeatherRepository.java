package com.hamburgcodingschool.weather;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.hamburgcodingschool.weather.model.City;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Teresa Holfeld, teresa.holfeld@gmail.com
 */
public class WeatherRepository {

    private static final String BASE_URL = "https://api.openweathermap.org";

    private final WeatherService service;
    private final String apiKey;
    private WeatherCallback callback;

    public WeatherRepository(String apiKey) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(WeatherService.class);
        this.apiKey = apiKey;
    }

    public void setCallback(WeatherCallback callback) {
        this.callback = callback;
    }

    public void getWeather(String city) {
        Call<City> cityCall = service.getWeather(city, apiKey);
        cityCall.enqueue(new Callback<City>() {
            @Override
            public void onResponse(@NonNull Call<City> call, @NonNull Response<City> response) {
                City city = response.body();
                callback.receiveWeather(city);
            }

            @Override
            public void onFailure(@NonNull Call<City> call, @NonNull Throwable t) {
                callback.receiveWeather(null);
            }
        });
    }

    public interface WeatherCallback {

        void receiveWeather(@Nullable City city);
    }
}
