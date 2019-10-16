package com.effective.org.effectivejava.examples.chapter02.item04;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-04-02
 * Time: 23:56:01
 * Description:
 */
class UtilityClassTest
{
    /**
     * 不能被实例化！！！
     * 由于显示构造器，是私有的，所以不可以在该类的外部访问他，
     * 这种习惯用法有点违背直觉，好像构造器就是用来专门设计成不能被调用一样
     * 因此明智的做法就是在代码中增加一条注释
     * // Suppress default constructor for noninstantiability（不可实例化）
     */
    // UtilityClass utilityClass = new UtilityClass();
}