package com.zhihei.basicknowledge.transfervalue;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-21
 * Time: 19:26:06
 * Description:
 */
public class TransferValueTest
{
    public void changeValue1(double money)
    {
        money = 3000.00;
    }

    public void changeValue2(Computer computer)
    {
        computer.setName("Apple");
    }

    public void changeValue3(String str)
    {
        str = "Lambda";
    }

    public static void main(String[] args)
    {
        TransferValueTest transferValueTest = new TransferValueTest();
        double money = 100.00;
        transferValueTest.changeValue1(money);
        /**
         * 基本类型看作用域
         */
        System.out.println(money);
        Computer computer = new Computer("Alienware", 20000.00);
        transferValueTest.changeValue2(computer);
        /**
         * 传递对象其实是传递的引用（地址值）
         */
        System.out.println(computer.getName());
        String str = "Linux";
        transferValueTest.changeValue3(str);
        /**
         * 常量池
         * 首先是指针引用，找不到的话新建，在指针指向新建对象。
         */
        System.out.println(str);
    }
}
