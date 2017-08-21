package com.lintcode.www.JuZhen;

/**
 * Created by ZKY on 2017-08-22 00:58.
 * 实现一个矩阵类Rectangle，包含如下的一些成员变量与函数：
 * 两个共有的成员变量 width 和 height 分别代表宽度和高度。
 * 一个构造函数，接受2个参数 width 和 height 来设定矩阵的宽度和高度。
 * 一个成员函数 getArea，返回这个矩阵的面积。
 * 样例
 * Rectangle rec = new Rectangle(3, 4);
 * rec.getArea(); // should get 12
 */
public class Rectangle
{
    public double width;
    public double height;

    public Rectangle(double width, double height)
    {
        this.width=width;
        this.height=height;
    }

    public double getArea()
    {
        return width*height;
    }

    public static void main(String[] args)
    {
        Rectangle rectangle =new Rectangle(3,4);
        double area = rectangle.getArea();
        System.out.println(area);
    }
}
