package com.hamburgcodingschool.weather;

import com.hamburgcodingschool.weather.model.City;
import com.hamburgcodingschool.weather.model.Weather;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.hamburgcodingschool.weather.WeatherPresenter.ERROR_TEXT;
import static junit.framework.Assert.assertEquals;

/**
 * @author Teresa Holfeld, teresa.holfeld@gmail.com
 */
public class WeatherPresenterTest {
    @Test
    public void getWeather() throws Exception {
        WeatherPresenter presenter = new WeatherPresenter(new WeatherView() {
            @Override
            public void setWeather(String weather) {
                // don't do anything
            }
        }, new WeatherRepository("") {
            @Override
            public void getWeather(String city) {
                String expected = "Hamburg";
                assertEquals(expected, city);
            }
        });
        presenter.getWeather("Hamburg");
    }

    @Test
    public void receiveWeather() throws Exception {
        WeatherPresenter presenter = new WeatherPresenter(new WeatherView() {
            @Override
            public void setWeather(String weather) {
                String expected = "clouds";
                assertEquals("Weather should be clouds", expected, weather);
            }
        }, new WeatherRepository("") {
            @Override
            public void getWeather(String city) {
                // don't do anything
            }
        });

        List<Weather> weatherList = new ArrayList<>();
        Weather weather = new Weather(1, "", "clouds", "");
        weatherList.add(weather);

        presenter.receiveWeather(new City(1, "", 0, weatherList));
    }

    @Test
    public void receiveWeather_isNull() throws Exception {
        WeatherPresenter presenter = new WeatherPresenter(new WeatherView() {
            @Override
            public void setWeather(String weather) {
                assertEquals(ERROR_TEXT, weather);
            }
        }, new WeatherRepository("") {
            @Override
            public void getWeather(String city) {
                // don't do anything
            }
        });

        presenter.receiveWeather(null);
    }
}