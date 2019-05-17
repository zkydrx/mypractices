package com.lintcode.company.facebook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-12-19
 * Time: 23:16
 * Description:
 * <p>
 * 给定一个字符串source和一个目标字符串target，在字符串source中找到包括所有目标字符串字母的子串。
 * <p>
 * 注意事项
 * 如果在source中没有这样的子串，返回""，如果有多个这样的子串，返回起始位置最小的子串。
 * <p>
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 说明
 * 在答案的子串中的字母在目标字符串中是否需要具有相同的顺序？
 * <p>
 * ——不需要。
 * <p>
 * 样例
 * 给出source = "ADOBECODEBANC"，target = "ABC" 满足要求的解  "BANC"
 */
public class FindSubString
{
   public static Logger logger = LoggerFactory.getLogger(FindSubString.class);

    public static void main(String[] args)
    {
        String s = new FindSubString().minWindow("ADOBECODEBANC", "ABC");

        System.out.println(s);
        logger.info("s:{}",s);
    }

    /**
     * This is a minimun window's question and should be think a lot about the method.
     * @param source
     * @param target
     * @return
     */
    public String minWindow(String source, String target)
    {
        boolean b = true;
        for (int i = target.length(); i < source.length() + 1; i++)
        {

            for (int j = 0; j < source.length() + 1 - i; j++)
            {
                /**
                 * attention the update the boolean.
                 */
                b = true;
                String substring = source.substring(j, i + j);

                for (int k = 0; k < target.length(); k++)
                {
                    if (!substring.contains(target.charAt(k) + ""))
                    {
                        b = false;
                        break;
                    }

                }
                if (b)
                {
                    return substring;
                }
            }
        }

        return null;
    }
}
