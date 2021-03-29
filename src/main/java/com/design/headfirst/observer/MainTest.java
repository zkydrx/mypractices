package com.design.headfirst.observer;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-03-29
 * Time: 00:24:08
 * Description:
 */
public class MainTest
{
    public static void main(String[] args)
    {
        WeatherData weatherData=new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay=new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(1,2,3f);
    }
}
