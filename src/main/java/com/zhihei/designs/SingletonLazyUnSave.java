package com.zhihei.designs;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-10-26
 * Time: 20:19:59
 * Description:
 * 懒汉模式，线程不安全
 */
public class SingletonLazyUnSave
{
    private static SingletonLazyUnSave instance;

    private SingletonLazyUnSave()
    {
    }

    public static SingletonLazyUnSave getInstance()
    {
        if (null == instance)
        {
            instance = new SingletonLazyUnSave();
        }
        return instance;
    }
}
