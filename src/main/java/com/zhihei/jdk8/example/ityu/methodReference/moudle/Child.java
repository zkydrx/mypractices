package com.zhihei.jdk8.example.ityu.methodReference.moudle;

import com.zhihei.jdk8.example.ityu.methodReference.MyMeet;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-16
 * Time: 12:09:51
 * Description:
 */
public class Child extends Parent
{
    @Override
    public void hello()
    {
        System.out.println("Hello I am child.");
    }

    public static void superMethod(MyMeet myMeet)
    {
        myMeet.meet();
    }

    public void show()
    {
        superMethod(() -> {
            Parent parent = new Parent();
            parent.hello();
        });
        /**
         * 使用super关键字调用父类
         *
         * 使用方法引用：使用super引用父类的成员方法：
         * 1.super已经存在
         * 2.父类的成员方法hello已经存在
         * 可以直接使用super引用父类的成员方法
         */
        superMethod(() -> super.hello());
    }
}
