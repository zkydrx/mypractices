package com.effective.org.effectivejava.examples.chapter02.item05;

public class Sum
{
    // Hideously slow program! Can you spot the object creation?
    public static void main(String[] args)
    {
        long time = System.currentTimeMillis();
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++)
        {
            sum += i;
        }
        System.out.println(sum);
        time = System.currentTimeMillis() - time;
        System.out.println("Long wait for " + time + " second");

        time = System.currentTimeMillis();
        long sum1 = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++)
        {
            sum1 += i;
        }

        time = System.currentTimeMillis() - time;
        System.out.println(sum1);
        System.out.println("long wait for " + time + " second");
    }
}
