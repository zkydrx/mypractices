package com.zhihei.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @author ZKY
 * @createTime 2019/7/5 1:08
 * @description
 */

public class PersonTest
{

    public static void main(String[] args)
    {
        Person person1 = new Person("zhangsan", 20);
        Person person2 = new Person("wangwu", 30);
        Person person3 = new Person("lisi", 40);

        List<Person> personList = Arrays.asList(person1, person2, person3);

        PersonTest test = new PersonTest();
        //        List<Person> personResult = test.getPersonByUserName("zhangsan", personList);

        //        List<Person> personResult = test.getPersonByAge(25, personList);
        //        personResult.forEach(person -> {
        //            System.out.println(person.toString());
        //        });

        List<Person> personResult = test.getPersonByAge2(20, personList, (age, persons) -> {
            return personList.stream().filter(person -> person.getAge() > age).collect(Collectors.toList());
        });

        personResult.forEach(person -> {
            System.out.println(person.toString());
        });

        System.out.println("-------------");
        List<Person> personResult2 = test.getPersonByAge2(20, personList, (age, persons) -> {
            return personList.stream().filter(person -> person.getAge() <= age).collect(Collectors.toList());
        });

        personResult2.forEach(person -> {
            System.out.println(person.toString());
        });

    }

    public List<Person> getPersonByUserName(String userName, List<Person> personList)
    {
        return personList.stream().filter(person -> person.getUsername().equals(userName)).collect(Collectors.toList());
    }

    /**
     * 这里大于写死了
     *
     * @param age
     * @param personList
     * @return
     */
    public List<Person> getPersonByAge(int age, List<Person> personList)
    {
        //参数2个，返回值一个 符合Bifunction函数
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (userAge, persons) -> persons.stream()
                                                                                                  .filter(person -> person.getAge() > userAge)
                                                                                                  .collect(Collectors.toList());

        return biFunction.apply(age, personList);
    }

    /**
     * 动作动态化
     *
     * @param age
     * @param personList
     * @param biFunction
     * @return
     */
    public List<Person> getPersonByAge2(int age, List<Person> personList, BiFunction<Integer, List<Person>, List<Person>> biFunction)
    {
        return biFunction.apply(age, personList);
    }
}
