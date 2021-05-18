package com.lintcode.www.GuessNumberGame;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-03
 * Time: 19:43
 * Description:
 */
public class GuessGameImpl implements GuessGame
{

    /**
     * The guess API is defined in the parent class GuessGame.
     *
     * @param num@return -1 if my number is lower, 1 if my number is higher, otherwise return 0
     */
    @Override
    public int guess(int num)
    {
        Random random = new Random(num);
        int i = random.nextInt();
        System.out.println("target: " + i);
        if (i == num)
        {
            return 0;
        }
        else if (i > num)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
}
