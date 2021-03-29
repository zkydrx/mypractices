package com.design.headfirst.strategy.duck;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-03-28
 * Time: 10:28:14
 * Description:
 */
public abstract class Duck
{
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void performQuack()
    {
        quackBehavior.quack();
    }

    public Duck()
    {
    }

    public abstract void display();

    public void performFly()
    {
        flyBehavior.fly();
    }

    public void swim()
    {
        System.out.println("All ducks float even decoys!");
    }


    public void setFlyBehavior(FlyBehavior flyBehavior)
    {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior)
    {
        this.quackBehavior = quackBehavior;
    }
}
