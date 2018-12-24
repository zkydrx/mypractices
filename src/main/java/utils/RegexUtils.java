package utils;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-07-31
 * Time: 17:45:19
 * Description:
 *
 * Regex
 *
 */
public class RegexUtils
{
    @Test
    public void testRegexCharacherAndNumber()
    {
        String content = "天神_渡劫";

        /**
         * 特殊字符
         */
        String regex = "[`~!@#$%^&*()_\\\\\\-+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);

        /**
         * 数字和英文字符和下划线
         */
        String regexNum = "[A-Za-z0-9_]";
        Pattern patternNum = Pattern.compile(regexNum);
        Matcher matcherNum = patternNum.matcher(content);

        if (matcher.find() || matcherNum.find())
        {
            System.out.println("输入字符串中含有特殊字符或者英文和数字以及下划线");
        }


        String regexFont = "[\\u4e00-\\u9fa5]";
        Pattern patternFont = Pattern.compile(regexFont);
        Matcher matcherFont = patternFont.matcher(content);

        if (matcherFont.find())
        {
            System.out.println("字符串中存在汉字！！！！！！！！！！！！！");
        }


    }

    @Test
    public void testIsDigit()
    {
        /**
         * 判断一个字符串是否都为数字
         */
        String strNum = "123";
        String strNum1 = "1231q";
        String strNum2 = "1231*";
        String strNum3 = "1231  ";
        String strNum4 = "123_";

        //true is digit
        System.out.println(strNum.matches("[0-9]{1,}"));
        //false contain character
        System.out.println(strNum1.matches("[0-9]{1,}"));
        //false contain *
        System.out.println(strNum2.matches("[0-9]{1,}"));
        //false contain blank
        System.out.println(strNum3.matches("[0-9]{1,}"));
        //false contain _
        System.out.println(strNum4.matches("[0-9]{1,}"));

    }
}
