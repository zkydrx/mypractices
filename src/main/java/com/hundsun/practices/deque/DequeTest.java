package com.hundsun.practices.deque;

import com.tuku.utils.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * 文件描述
 *
 **/
public class DequeTest
{
    @Test

    public void test()
    {
        Collection<Person> personList = new ArrayDeque<>();
        personList.add(Person.builder().age("1").name("zky").money(2.0).sex('m').build());
        personList.add(Person.builder().age("2").name("zky1").money(3.0).sex('m').build());
        personList.add(Person.builder().age("3").name("zky2").money(4.0).sex('m').build());
        personList.add(Person.builder().age("4").name("zky3").money(5.0).sex('m').build());
        personList.add(Person.builder().age("5").name("zky4").money(6.0).sex('m').build());
        Deque<Person> changeDeque = new ArrayDeque<>(personList);
        changeDeque.pop();

        for (Person person : changeDeque)
        {
            System.out.println(person.toString());
        }


        Collection<Son> personList1 = personList.stream().map(person -> {
            Son son = Son.builder().build();
            son.setName(person.getName());
            return son;
        }).sorted(Comparator.comparing(Son::getName).reversed()).collect(Collectors.toList());
    }
}
