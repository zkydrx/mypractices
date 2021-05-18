package com.zhihei.jdk8.example.ityu.methodReference;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-16
 * Time: 13:50:36
 * Description:
 */
@FunctionalInterface
public interface ArrayBuilder
{
    /**
     * 创建int 类型的数组额方法，参数传递数组的长度，返回创建好的int类型数组
     *
     * @param length
     * @return
     */
    int[] builderArray(int length);
}
