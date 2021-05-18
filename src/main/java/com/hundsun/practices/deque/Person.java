package com.hundsun.practices.deque;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2020-01-06
 * Time: 15:41:10
 * Description:
 */
@Data
@ToString
@Builder
public class Person
{
    private String name;
    private String age;
    private Double money;
    private Character sex;
    public String[] toArray()
    {
        return new String[]{name, age, String.valueOf(money), String.valueOf(sex)};
    }
}
