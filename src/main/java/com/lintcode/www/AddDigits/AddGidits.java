package com.lintcode.www.AddDigits;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-05
 * Time: 23:39
 * Description:
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * Example
 * Given num = 38.
 * The process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return 2.
 */
public class AddGidits
{
    public int addDigits(int num)
    {
        while (num > 9)
        {
            int theNum = getTheNum(num);
            num = theNum;
        }
        return num;
    }

    public int getTheNum(int num)
    {
        int sum = 0;
        while (num > 0)
        {
            int temp = num % 10;
            num /= 10;
            sum += temp;
        }
        return sum;
    }


    public static void main(String[] args)
    {
        AddGidits addGidits = new AddGidits();
        int theNum = addGidits.getTheNum(1111);
        System.out.println(theNum);
        System.out.println(addGidits.addDigits(38));

    }
}
