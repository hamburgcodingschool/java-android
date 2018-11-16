package com.hamburgcodingschool.weather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.hello

class MainActivity : AppCompatActivity(), WeatherView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = WeatherRepository(getString(R.string.OpenWeatherMapKey))
        val presenter = WeatherPresenter(this, repository)
        repository.setCallback(presenter)
        presenter.getWeather("Hamburg")

        Log.d("MainActivity", "We created a weather activity")
    }

    override fun setWeather(weather: String) {
        hello.text = weather
    }
}
