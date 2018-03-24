package com.hamburgcodingschool.weather;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        int expected = 4;
        int actual = 2 + 2;
        assertEquals(expected, actual);
    }

    @Test
    public void boolean_isTrue() throws Exception {
        boolean actual = true;
        assertFalse(actual);
    }
}