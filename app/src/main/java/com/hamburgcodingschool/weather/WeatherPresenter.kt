package com.hamburgcodingschool.weather

import com.hamburgcodingschool.weather.model.City

/**
 * @author Teresa Holfeld, teresa.holfeld@gmail.com
 */
class WeatherPresenter(private val weatherView: WeatherView, private val weatherRepository: WeatherRepository) : WeatherRepository.WeatherCallback {

    fun getWeather(city: String) {
        weatherRepository.getWeather(city)
    }

    override fun receiveWeather(city: City?) {
        if (city == null) {
            weatherView.setWeather(ERROR_TEXT)
        } else {
            val weather = city.weather[0].description
            weatherView.setWeather(weather)
        }
    }

    companion object {

        internal val ERROR_TEXT = "Sorry, something went wrong."
    }
}
