package com.design.headfirst.observer;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-03-29 Time: 00:08:14
 * Description:
 */
public interface Observer {
	void update(float temp, float humidity, float pressure);
}
