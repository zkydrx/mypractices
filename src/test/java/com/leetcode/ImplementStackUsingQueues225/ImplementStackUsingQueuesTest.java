package com.leetcode.ImplementStackUsingQueues225;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-04-27
 * Time: 01:01:47
 * Description:
 */
class ImplementStackUsingQueuesTest
{
    ImplementStackUsingQueues implementStackUsingQueues = new ImplementStackUsingQueues();

    @BeforeEach
    void setUp()
    {
        System.out.println("String...");
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("Ending...");
    }

    @Test
    void pop()
    {
        implementStackUsingQueues.pop();
    }

    @Test
    void push()
    {
        implementStackUsingQueues.push(3);
    }

    @Test
    void empty()
    {
        implementStackUsingQueues.empty();
    }

    @Test
    void top()
    {
        int top = implementStackUsingQueues.top();

        System.out.println(top);
    }
}