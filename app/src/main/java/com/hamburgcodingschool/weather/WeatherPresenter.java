package com.hamburgcodingschool.weather;

import android.support.annotation.Nullable;

import com.hamburgcodingschool.weather.model.City;

/**
 * @author Teresa Holfeld, teresa.holfeld@gmail.com
 */
public class WeatherPresenter implements WeatherRepository.WeatherRecipient {

    private static final String ERROR_TEXT = "Sorry, something went wrong.";

    private final WeatherView weatherView;
    private final WeatherRepository weatherRepository;


    public WeatherPresenter(WeatherView weatherView, WeatherRepository weatherRepository) {
        this.weatherView = weatherView;
        this.weatherRepository = weatherRepository;
    }

    public void getWeather(String city) {
        weatherRepository.getWeather(city);
    }

    @Override
    public void receiveWeather(@Nullable City city) {
        if (city == null) {
            weatherView.setWeather(ERROR_TEXT);
        } else {
            String weather = city.getWeather().get(0).getDescription();
            weatherView.setWeather(weather);
        }
    }
}
