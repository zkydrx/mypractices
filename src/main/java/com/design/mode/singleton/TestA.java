package com.design.mode.singleton;

/**
 * 单例对象（Singleton）是一种常用的设计模式。在Java应用中，单例对象能保证在一个JVM中，该对象只有一个实例存在。这样的模式有几个好处：
 * <p>
 * 1、某些类创建比较频繁，对于一些大型的对象，这是一笔很大的系统开销。
 * <p>
 * 2、省去了new操作符，降低了系统内存的使用频率，减轻GC压力。
 * <p>
 * 3、有些类如交易所的核心交易引擎，控制着交易流程，如果该类可以创建多个的话，系统完全乱了。
 * （比如一个军队出现了多个司令员同时指挥，肯定会乱成一团），所以只有使用单例模式，才能保证核心交易服务器独立控制整个流程。
 */
public class TestA
{
    public static void main(String[] args)
    {
        // Can not create a instance !
        //SingletonA instance1 = new SingletonA();  
        SingletonA instance2 = SingletonA.getInstance();
        if (instance2 != null)
        {
            instance2.setNum();
            System.out.println("i is:" + instance2.getNum());
        }
        SingletonA instance3 = SingletonA.getInstance();
        if (instance3 == null)
        {
            System.out.println("Can not get instance twice !");
        }
    }
}