package com.zhihei.jdk8.methodreference;

/**
 * @author ZKY
 * @createTime 2019/7/6 12:38
 * @description
 */

public class Student
{

    private String name;

    private int score;

    public static int compareStudentByScore(Student student1, Student student2)
    {

        return student1.getScore() - student2.getScore();
    }

    public static int compareStudentByName(Student student1, Student student2)
    {

        return student1.getName().compareToIgnoreCase(student2.getName());//不区分大小写 按照字符串的大小排序
    }

    //正确的设计
    public int compareByScore(Student student)
    {
        return this.getScore() - student.getScore();
    }

    public int compareSByName(Student student)
    {
        return this.getName().compareToIgnoreCase(student.getName());
    }

    public Student(String name, int score)
    {
        this.name = name;
        this.score = score;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }
}
