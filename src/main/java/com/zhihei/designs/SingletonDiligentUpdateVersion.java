package com.zhihei.designs;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-10-26
 * Time: 20:37:15
 * Description:
 * 饿汉模式变种4
 * 升级版线程安全的
 */
public class SingletonDiligentUpdateVersion
{
    private volatile static SingletonDiligentUpdateVersion instance;

    private SingletonDiligentUpdateVersion()
    {
    }

    public static SingletonDiligentUpdateVersion getInstance()
    {
        if (null == instance)
        {
            synchronized (SingletonDiligentUpdateVersion.class)
            {
                if (null == instance)
                {
                    instance = new SingletonDiligentUpdateVersion();
                }
            }
        }
        return instance;
    }
}
