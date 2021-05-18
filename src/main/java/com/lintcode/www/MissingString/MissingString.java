package com.lintcode.www.MissingString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-03
 * Time: 14:19
 * Description:
 * Given two strings, you have to find the missing string.
 * Example
 * Given a string str1 = This is an example
 * Given another string str2 = is example
 * <p>
 * Return ["This", "an"]
 */
public class MissingString
{
    public List<String> missingString(String str1, String str2)
    {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list = new ArrayList<>();
        while (str1.length() > 0)
        {
            if (str1.contains(" "))
            {
                String temp = str1.substring(0, str1.indexOf(" "));
                list1.add(temp);
                str1 = str1.substring(str1.indexOf(" ") + 1, str1.length());
            }
            else
            {
                list1.add(str1);
                str1 = "";
            }
        }

        while (str2.length() > 0)
        {
            if (str2.contains(" "))
            {
                String temp = str2.substring(0, str2.indexOf(" "));
                list2.add(temp);
                str2 = str2.substring(str2.indexOf(" ") + 1, str2.length());
            }
            else
            {
                list2.add(str2);
                str2 = "";
            }
        }
        for (int i = 0; i < list1.size(); i++)
        {
            for (int j = 0; j < list2.size(); j++)
            {
                if (list1.get(i).equals(list2.get(j)))
                {
                    list.add(list1.get(i));
                }
            }
        }
        list1.removeAll(list);
        return list1;
    }


    public static void main(String[] args)
    {
        MissingString missingString = new MissingString();
        List<String> list = missingString.missingString("This is an example", "is example");

        System.out.println(list);
    }
}
