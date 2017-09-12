package com.lintcode.www.StringToInteger;


import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-11
 * Time: 00:07
 * Description:
 * 实现atoi这个函数，将一个字符串转换为整数。
 * 如果没有合法的整数，返回0。
 * 如果整数超出了32位整数的范围，
 * 返回INT_MAX(2147483647)如果是正整数，
 * 或者INT_MIN(-2147483648)如果是负整数。
 * 样例
 * "10" =>10
 * <p>
 * "-1" => -1
 * <p>
 * "123123123123123" => 2147483647
 * <p>
 * "1.0" => 1
 */
public class DoMain
{
    /**
     * 解析一个字符串，将字符串转为整数。
     *
     * @param str
     * @return
     */
    public int atoi(String str)
    {
        String regex = "[^\\d]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        boolean bea = false;
        if (str.contains("-"))
        {
            str = str.substring(1,str.length());
            bea = true;
        }
        if(matcher.find())
        {
            return 0;
        }
        else if (str.contains(".")&&!(str.contains("-")))
        {

            if (str.length() > 10)
            {
                if(bea)
                {
                    return -2147383648;
                }
                return 2147483647;
            }
            else if (str.length() == 10 && str.compareTo("2147483647") > 0)

            {
                if(bea)
                {
                    return -2147483648;
                }
                return 2147483647;
            }
            else
            {
                return (int) Double.parseDouble(str);
            }
        }
        else
        {

            if (str.length() > 10)
            {
                if(bea)
                {
                    return -2147483648;
                }
                return 2147483647;
            }

            else if (str.length() == 10 && str.compareTo("2147483647") > 0)
            {
                if(bea)
                {
                    return -2147483648;
                }
                return 2147483647;
            }
            else
            {
                return Integer.parseInt(str);
            }
        }
    }

    public static void main(String[] args)
    {
        DoMain doMain = new DoMain();
        int atoi = doMain.atoi("1.0");
        System.out.println(atoi);
        System.out.println(doMain.atoi("-1"));
        System.out.println(doMain.atoi("-123123123123123"));
        System.out.println(doMain.atoi("dkk"));
        for(int i = 1; i < 20 ; i++)
        {
            String s = UUID.randomUUID().toString().replaceAll("-", "");
            System.out.println();
            System.out.println(s);
        }
    }
}
