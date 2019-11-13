package com.zhihei.jdk8.example.ityu.functioninterface;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-14
 * Time: 01:25:50
 * Description:
 */
@FunctionalInterface
public interface MessageBuilder
{
    /**
     * 定义一个拼接消息的抽象方法,返回被拼接的消息
     * @return
     */
    String builderMessage();
}
