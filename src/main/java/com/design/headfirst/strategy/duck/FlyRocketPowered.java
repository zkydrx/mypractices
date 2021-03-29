package com.design.headfirst.strategy.duck;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-03-28
 * Time: 10:49:38
 * Description:
 */
public class FlyRocketPowered implements FlyBehavior
{

    @Override
    public void fly()
    {
        System.out.println("I'm flyindg with a rocket！");
    }
}
