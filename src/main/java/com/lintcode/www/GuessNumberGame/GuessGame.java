package com.lintcode.www.GuessNumberGame;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-03
 * Time: 19:31
 * Description:
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * <p>
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * Example
 * n = 10, I pick 4 (but you don't know)
 * <p>
 * Return 4. Correct !
 */
public interface GuessGame
{
    /**
     * The guess API is defined in the parent class GuessGame.
     *
     * @param num, your guess
     * @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
     */
    int guess(int num);
}
