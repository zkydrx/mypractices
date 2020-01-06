package com.zhihei.basicknowledge.javabasic.jvm.gc;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-12-16
 * Time: 23:49:36
 * Description:
 */
public class HelloGc
{

    public static void main(String[] args) throws InterruptedException
    {
        /**
         * 虚拟机的初始容量为系统内存的1/64
         */
        System.out.println(Runtime.getRuntime().totalMemory()/(double)1000/1000+"M");
        /**
         * 虚拟机的最大占用内存为系统内存的1/4
         */
        System.out.println(Runtime.getRuntime().maxMemory()/(double)1000/1000+"M");

        Thread.sleep(10000000L);
        String userNameTime=null;

    }
}
