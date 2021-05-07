package com.design.headfirst.strategy.duck;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-03-28
 * Time: 10:48:16
 * Description:
 */
public class ModelDuck extends Duck
{

    public ModelDuck()
    {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display()
    {
        System.out.println("I'm a model duck");
    }
}
