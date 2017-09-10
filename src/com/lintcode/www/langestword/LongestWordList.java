package com.lintcode.www.langestword;

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

 {
 "dog",
 "google",
 "facebook",
 "internationalization",
 "blabla"
 }
 中, 最长的单词集合为 ["internationalization"]

 在词典

 {
 "like",
 "love",
 "hate",
 "yes"
 }
 中，最长的单词集合为 ["like", "love", "hate"]
 */
public class LongestWordList
{
    /**
     * 返回一个单词(字符串)的长度
     * @param str
     * @return
     */
    public int getWordLong(String str)
    {
        return str.length();
    }


    public List<String> longestWords(String[] dictionary)
    {
        int[] ints = new int[dictionary.length];
        for (int i = 0; i < dictionary.length; i++)
        {
            ints[i] = dictionary[i].length();
        }
        Arrays.sort(ints);

    }
}
