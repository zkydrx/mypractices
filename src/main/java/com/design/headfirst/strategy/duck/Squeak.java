package com.design.headfirst.strategy.duck;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-03-28
 * Time: 10:38:47
 * Description:
 */
public class Squeak implements QuackBehavior
{

    @Override
    public void quack()
    {
        System.out.println("Squeak");
    }
}
