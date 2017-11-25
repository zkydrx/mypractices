package com.lintcode.www.RotateWords;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-17
 * Time: 15:44
 * Description:
 * The words are same rotate words if rotate the word to the right by loop, and get another. Count how many different
 * rotate word sets in dictionary.
 * <p>
 * E.g. picture and turepic are same rotate words.
 * <p>
 * <p>
 * 样例
 * Given dict = ["picture", "turepic", "icturep", "word", "ordw", "lint"]
 * return 3.
 * <p>
 * "picture", "turepic", "icturep" are same ratote words.
 * "word", "ordw" are same too.
 * "lint" is the third word that different from the previous two words.
 */
public class GetTheWords
{
    /**
     * 来自于网上
     * @param words
     * @return
     */
    public int countRotateWords(List<String> words)
    {
        int index = 0;
        Set<String> set = new LinkedHashSet<String>();
        set.addAll(words);
        if (words.isEmpty())
            return 0;
        else
        {
            while (!set.isEmpty())
            {
                String str = set.iterator().next();
                for (int i = 0; i < str.length(); i++)
                {
                    if (set.contains(str.substring(i, str.length()) + str.substring(0, i)))
                        set.remove(str.substring(i, str.length()) + str.substring(0, i));
                }
                index = index + 1;
            }
        }
        return index;
    }

}
