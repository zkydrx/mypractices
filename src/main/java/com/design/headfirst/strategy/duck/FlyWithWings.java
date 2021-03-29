package com.design.headfirst.strategy.duck;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-03-28
 * Time: 10:37:02
 * Description:
 */
public class FlyWithWings implements FlyBehavior
{

    @Override
    public void fly()
    {
        System.out.println("I'm flying!!");
    }
}
