package com.zhihei.jdk8;

/**
 * @author ZKY
 * @createTime 2019/7/6 9:34
 * @description 学生类
 */

public class Student
{
    private String name = "zhangsan";
    private int age = 20;

    public Student()
    {

    }

    public Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
