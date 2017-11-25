package com.lintcode.www.RotateWords;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-18
 * Time: 09:01
 * Description:
 */
class GetTheWordsTest
{
    @Test
    void countRotateWords()
    {
        GetTheWords theWords = new GetTheWords();
        String[] dict = new String[6];
        /**
         * "picture","turepic", "icturep", "word", "ordw", "lint"
         */
//        for (int i = 0; i < dict.length; i++)
//        {
//            dict[i]
//        }
        List<String> list = new ArrayList<>();
        list.add("picture");
        list.add("turepic");
        list.add("icturep");
        list.add("word");
        list.add("ordw");
        list.add("lint");
        int i = theWords.countRotateWords(list);

        System.out.println(i);

//        System.out.println(list);
//        Arrays.sort(list.toArray());
//        System.out.println(list);


    }

}