package com.hamburgcodingschool.weather.model;

import java.util.List;

/**
 * @author Teresa Holfeld, teresa.holfeld@gmail.com
 */
public class City {
    private final int id;
    private final String name;
    private final int cod;
    private final List<Weather> weather;

    public City(int id, String name, int cod, List<Weather> weather) {
        this.id = id;
        this.name = name;
        this.cod = cod;
        this.weather = weather;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCod() {
        return cod;
    }

    public List<Weather> getWeather() {
        return weather;
    }
}
