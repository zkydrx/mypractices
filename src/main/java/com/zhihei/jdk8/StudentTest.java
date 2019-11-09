package com.zhihei.jdk8;

import java.util.function.Supplier;

/**
 * @author ZKY
 * @createTime 2019/7/6 9:55
 * @description
 */

public class StudentTest
{

    public static void main(String[] args)
    {
        //以前的方法
        //        Student student = new Student();
        //        student.getName();

        //不接受参数返回一个结果
        Supplier<Student> supplier = () -> new Student();
        System.out.println(supplier.get().getName());

        System.out.println("---------------");

        //构造方法引用(必须无参)
        Supplier<Student> supplier2 = Student::new;
        System.out.println(supplier2.get().getName());

        //构造方法引用(有参)则无法调用Supplier
    }
}
