package com.zhihei.designs;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-10-26
 * Time: 20:19:59
 * Description:
 * 懒汉模式，线程不安全
 */
public class SingletonLazySave
{
    private static SingletonLazySave instance;

    private SingletonLazySave()
    {
    }

    public static synchronized SingletonLazySave getInstance()
    {
        if (null == instance)
        {
            instance = new SingletonLazySave();
        }
        return instance;
    }
}
