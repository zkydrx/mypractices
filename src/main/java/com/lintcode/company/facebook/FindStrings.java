package com.lintcode.company.facebook;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-12-15
 * Time: 17:12
 * Description:
 * 对于一个给定的 source 字符串和一个 target 字符串，
 * 你应该在 source 字符串中找出 target
 * 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。
 * <p>
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 说明
 * 在面试中我是否需要实现KMP算法？
 * <p>
 * 不需要，当这种问题出现在面试中时，面试官很可能只是想要测试一下你的基础应用能力。
 * 当然你需要先跟面试官确认清楚要怎么实现这个题。
 * 样例
 * 如果 source = "source" 和 target = "target"，返回 -1。
 * <p>
 * 如果 source = "abcdabcdefg" 和 target = "bcd"，返回 1。
 */
public class FindStrings
{
    public int getTheRightStrings(String source, String target)
    {
        int temp = 0;
        if (!source.equals(target))
        {
            temp = 1;
        }
        else
        {
            temp = -1;
        }

        return temp;
    }

    public static void main(String[] args)
    {
        int theRightStrings = new FindStrings().getTheRightStrings("source", "source");

        System.out.println(theRightStrings);
    }
}
