package com.zhihei.jdk8;

/**
 * @author ZKY
 * @createTime 2019/7/3 23:01
 * @description
 */
@FunctionalInterface
public interface MyInterface
{
    void test();
    //void test2(); //FunctionalInterface报错 只能有一个

    //静态方法也不算
    static void test3(String param)
    {
        System.out.println("helle" + param);
    }

    @Override
    String toString(); //重写了 Object类的toString的方法 个数不算 test()只有一个满足函数式接口条件
}

class Test2
{

    public void myTest(MyInterface myInterface)
    {
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args)
    {
        Test2 test2 = new Test2();
        //        test2.myTest(new MyInterface() {
        //            @Override
        //            public void test() {
        //                System.out.println("myTest");
        //            }
        //        });

        //lambda表达式
        test2.myTest(() -> {
            System.out.println("myTest");
        });

        System.out.println("-------------");

        MyInterface myInterface = () -> {
            System.out.println("hello");
        };
        System.out.println(myInterface.getClass());//class com.gradle.ZKY.Test2$$Lambda$2/41359092
        System.out.println(myInterface.getClass().getSuperclass());//class java.lang.Object
        System.out.println(myInterface.getClass().getInterfaces()[0]);//interface com.gradle.ZKY.MyInterface
    }
}