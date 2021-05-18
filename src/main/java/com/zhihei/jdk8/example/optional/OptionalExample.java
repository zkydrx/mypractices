package com.zhihei.jdk8.example.optional;

import com.zhihei.jdk8.example.moudle.Person;
import org.junit.jupiter.api.Test;
import utils.collections.Entity.User;

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
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));
    }

    /**
     * orElse()无论值是否为空都会执行一遍；
     * 而orElseGet()只有当值为空时，才会执行
     */
    @Test
    public void testNPE()
    {
        Optional<String> optionalUser = Optional.of("");
        System.out.println(optionalUser.orElse("A"));
        System.out.println(optionalUser.orElseGet(() -> "B"));

        User user = (User) Optional.ofNullable(null).orElseGet(() -> new User(0L, "Unknown", 3, "addminre"));

        System.out.println("Username is: " + user.getName());
    }

}
