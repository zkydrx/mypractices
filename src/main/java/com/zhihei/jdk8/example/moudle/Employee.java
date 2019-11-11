package com.zhihei.jdk8.example.moudle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-10
 * Time: 12:43:06
 * Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee
{
    private String name;
    private int salary;
    private String office;
    private int age;
}
