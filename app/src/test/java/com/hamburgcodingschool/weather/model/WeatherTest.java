package com.hamburgcodingschool.weather.model;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Teresa Holfeld, teresa.holfeld@gmail.com
 */
public class WeatherTest {
    @Test
    public void getId() throws Exception {
        Weather weather = new Weather(34, "", "", "");
        int expected = 34;
        int actual = weather.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void getMain() throws Exception {
    }

    @Test
    public void getDescription() throws Exception {
    }

    @Test
    public void getIcon() throws Exception {
    }

}