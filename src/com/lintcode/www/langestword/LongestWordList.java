package com.lintcode.www.langestword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-10
 * Time: 23:50
 * Description:
 * 给一个词典，找出其中所有最长的单词。
 * 在词典
 * <p>
 * {
 * "dog",
 * "google",
 * "facebook",
 * "internationalization",
 * "blabla"
 * }
 * 中, 最长的单词集合为 ["internationalization"]
 * <p>
 * 在词典
 * <p>
 * {
 * "like",
 * "love",
 * "hate",
 * "yes"
 * }
 * 中，最长的单词集合为 ["like", "love", "hate"]
 */
public class LongestWordList
{
    /**
     * 获得最长的单词列表
     * @param dictionary
     * @return
     */
    public List<String> longestWords(String[] dictionary)
    {
        int[] ints = new int[dictionary.length];
        for (int i = 0; i < dictionary.length; i++)
        {
            ints[i] = dictionary[i].length();
        }
        Arrays.sort(ints);
        ArrayList<String> list = new ArrayList<>();
        for (String str : dictionary)
        {
            if (str.length() == ints[ints.length - 1])
            {
                list.add(str);
            }
        }
        return list;
    }

    public static void main(String[] args)
    {
        LongestWordList longestWordList = new LongestWordList();
        String[] str = {"like", "lov6666666666666e", "hate", "yes"};
        List<String> list = longestWordList.longestWords(str);
        System.out.println(list);
    }
}
