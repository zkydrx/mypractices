package com.lintcode.www.LeftPad;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-07
 * Time: 14:28
 * Description:
 * You know what, left pad is javascript package and referenced by React:
 * Github link
 * <p>
 * One day his author unpublished it, then a lot of javascript projects in the world broken.
 * <p>
 * You can see from github it's only 11 lines.
 * <p>
 * You job is to implement the left pad function. If you do not know what left pad does, see examples below and guess.
 * Example
 * leftpad("foo", 5)
 * >> "  foo"
 * <p>
 * leftpad("foobar", 6)
 * >> "foobar"
 * <p>
 * leftpad("1", 2, "0")
 * >> "01"
 */
public class LeftPad
{
    static public String leftPad(String originalStr, int size)
    {
        String strtemp = originalStr;
        if(originalStr.length() >=size)
        {
            return originalStr.substring(0,size);
        }
        else
        {
            for (int i = 0; i < size-originalStr.length(); i++)
            {
                strtemp = " " +strtemp;
            }
            return strtemp;
        }
    }


    public String leftPad(String originalStr, int size, char padChar)
    {
        String strtemp = originalStr;
        if(originalStr.length() >=size)
        {
            return originalStr.substring(0,size);
        }
        else
        {
            for (int i = 0; i < size-originalStr.length(); i++)
            {
                strtemp = padChar +strtemp;
            }
            return strtemp;
        }
    }

    public static void main(String[] args)
    {
        LeftPad leftPad = new LeftPad();
        System.out.println(leftPad.leftPad("foo",5));
        System.out.println(leftPad.leftPad("1",2,'c'));
        System.out.println(leftPad.leftPad("TESTTEST", 10, '+'));
    }
}
