package com.design.headfirst.observer;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-03-29
 * Time: 00:07:09
 * Description:
 */
public interface Subject
{
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
