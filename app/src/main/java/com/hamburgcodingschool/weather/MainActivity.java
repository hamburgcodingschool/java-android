package com.hamburgcodingschool.weather;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hamburgcodingschool.weather.model.City;
import com.hamburgcodingschool.weather.model.Weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView weatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherTextView = findViewById(R.id.hello);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService service = retrofit.create(WeatherService.class);

        Call<City> cityCall = service.getWeather("Hamburg", getString(R.string.OpenWeatherMapKey));
        cityCall.enqueue(new Callback<City>() {
            @Override
            public void onResponse(@NonNull Call<City> call, @NonNull Response<City> response) {
                Weather weather = response.body().weather.get(0);
                weatherTextView.setText(weather.description);
            }

            @Override
            public void onFailure(@NonNull Call<City> call, @NonNull Throwable t) {
                weatherTextView.setText("Sorry, something went wrong.");
            }
        });
    }
}
