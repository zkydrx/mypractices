package com.design.headfirst.observer;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-03-29
 * Time: 00:10:12
 * Description:
 * 观察者设计模式练习
 */
public class WeatherData implements Subject
{
    private ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;


    public WeatherData()
    {
        observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer o)
    {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o)
    {
        int i = observers.indexOf(o);
        if (i >= 0)
        {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers()
    {
        for (int i = 0; i < observers.size(); i++)
        {
            Observer o = (Observer) observers.get(i);
            o.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(float temperature, float hundidity, float pressure)
    {
        this.temperature = temperature;
        this.humidity = hundidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public void measurementsChanged()
    {
        notifyObservers();
    }
}
