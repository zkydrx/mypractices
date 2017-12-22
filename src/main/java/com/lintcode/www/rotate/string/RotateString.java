package com.lintcode.www.rotate.string;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-12-23
 * Time: 00:09
 * Description:
 * 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
 * <p>
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 样例
 * 对于字符串 "abcdefg".
 * <p>
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 */
public class RotateString
{
    public static void main(String[] args)
    {
        String abcdefg = new RotateString().getRotateString("abcdefg", 0);
        String abcdefg1 = new RotateString().getRotateString("abcdefg", 1);
        String abcdefg2 = new RotateString().getRotateString("abcdefg", 2);
        String abcdefg3 = new RotateString().getRotateString("abcdefg", 3);
        String abcdefg4 = new RotateString().getRotateString("abcdefg", 4);

        System.out.println("abcdefg:" + abcdefg);
        System.out.println("abcdefg1:" + abcdefg1);
        System.out.println("abcdefg2:" + abcdefg2);
        System.out.println("abcdefg3:" + abcdefg3);
        System.out.println("abcdefg4:" + abcdefg4);
    }

    /**
     * @param sources
     * @param offset
     * @return
     */
    public String getRotateString(String sources, int offset)
    {
        /**
         * 考虑到offset 的值可能大于sources的长度，所以进行取余操作。
         * 如果余数为零的那么就是不用移动任何一个元素即可达到要求。
         *
         */
        int remainder = offset % sources.length();

        String substring = sources.substring(0, sources.length() - remainder);

        String substring1 = sources.substring(sources.length() - remainder, sources.length());

        StringBuffer stringBuffer = new StringBuffer(substring1 + substring);

        String result = stringBuffer.toString();


        return result;
    }
}
