package com.hamburgcodingschool.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements WeatherView {

    private TextView weatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherTextView = findViewById(R.id.hello);

        WeatherRepository repository = new WeatherRepository(getString(R.string.OpenWeatherMapKey));
        WeatherPresenter presenter = new WeatherPresenter(this, repository);
        repository.setCallback(presenter);
        presenter.getWeather("Hamburg");

        Log.d("MainActivity", "We created a weather activity");
    }

    @Override
    public void setWeather(String weather) {
        weatherTextView.setText(weather);
    }
}
