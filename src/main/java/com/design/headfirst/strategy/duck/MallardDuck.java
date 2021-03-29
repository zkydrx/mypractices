package com.design.headfirst.strategy.duck;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-03-28
 * Time: 10:41:20
 * Description:
 */
public class MallardDuck extends Duck
{

    public MallardDuck()
    {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }


    @Override
    public void display()
    {
        System.out.println(" I'm a real Mallard duck");
    }
}
