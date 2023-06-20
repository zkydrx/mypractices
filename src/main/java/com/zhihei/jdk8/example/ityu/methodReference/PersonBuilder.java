package com.zhihei.jdk8.example.ityu.methodReference;

import com.zhihei.jdk8.example.ityu.methodReference.moudle.Person1;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-16 Time: 12:57:30
 * Description:
 */
@FunctionalInterface
public interface PersonBuilder {
	/**
	 * 根据传递的姓名创建person对象
	 *
	 * @param name
	 * @return
	 */
	Person1 builderPerson(String name, Integer age);
}
