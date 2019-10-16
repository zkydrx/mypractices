package com.effective.org.effectivejava.examples.chapter02.item05.fastversion;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-04-03
 * Time: 01:03:40
 * Description:
 */
class PersonTest
{

    @Test
    void isBabyBoomer()
    {
        Person person = new Person(new Date());
        boolean babyBoomer = person.isBabyBoomer();

        System.out.println(babyBoomer);
    }
}