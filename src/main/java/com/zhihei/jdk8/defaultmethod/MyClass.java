package com.zhihei.jdk8.defaultmethod;

/**
 * @author ZKY
 * @createTime 2019/7/6 23:10
 * @description
 */

public class MyClass extends MyInterface1Impl implements MyInterface2
{

    // 实现多个接口时 接口中的默认方法重名时 必须重写
    //    @Override
    //    public void myMethod() {
    //        MyInterface2.super.myMethod();
    //    }

    public static void main(String[] args)
    {
        MyClass myClass = new MyClass();
        /**
         * 当继承类和实现接口时  方法同名时  实现类的优先级比接口高
         * 结果是：MyInterface1Impl
         */
        myClass.myMethod();
    }

}
