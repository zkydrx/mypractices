package com.zhihei.jdk8.example.optional;

import com.zhihei.jdk8.example.moudle.Person;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-10
 * Time: 12:35:53
 * Description:
 */
public class OptionalExample
{
    public static void main(String[] args)
    {
        Optional<String> optional = Optional.of("hello");
        System.out.println(optional.isPresent());
        Optional<Person> build = Optional.of(Person.builder().build());

        System.out.println(build.isPresent());
        System.out.println(optional.get());
        System.out.println(optional.orElse("false"));
        optional.ifPresent((s)-> System.out.println(s.charAt(0)));
    }

}
