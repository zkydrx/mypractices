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

        if(matcherFont.find())
        {
            System.out.println("字符串中存在汉字！！！！！！！！！！！！！");
        }


    }
}
