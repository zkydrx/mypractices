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
        String content = "";

        /**
         * 特殊字符
         */
        String regex = "[`~!@#$%^&*()_\\\\\\-+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);

        /**
         * 数字和英文字符以及下划线
         */
        String regexNum = "^\\w+$";
        Pattern patternNum = Pattern.compile(regexNum);
        Matcher matcherNum = patternNum.matcher(content);

        if (matcher.find() || matcherNum.find())
        {
            System.out.println("输入字符串中含有特殊字符或者英文和数字以及下划线");
        }
    }
}
