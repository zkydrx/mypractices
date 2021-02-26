package knowledgeable.review202101.msb.spring.writeioc.test;

import knowledgeable.review202101.msb.spring.writeioc.annoation.AutoWired;
import knowledgeable.review202101.msb.spring.writeioc.controller.UserController;
import knowledgeable.review202101.msb.spring.writeioc.service.UserService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-02-22
 * Time: 20:48:51
 * Description:
 * 手写ioc测试类
 */
public class MyTest
{
    /**
     * 通过反射来赋值
     *
     * @throws NoSuchFieldException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void test() throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException
    {
        UserController userController = new UserController();
        Class<? extends UserController> aClass = userController.getClass();

        //1.创建对象
        UserService userService = new UserService();
        System.out.println(userService);
        Field serviceFiled = aClass.getDeclaredField("userService");
        serviceFiled.setAccessible(true);
        //2.通过方法设置具体的属性值
        String name = serviceFiled.getName();
        //3.拼接方法名
        name = name.substring(0, 1).toUpperCase(Locale.ROOT) + name.substring(1);
        String methodName = "set" + name;
        //4.通过方法名注入属性的对象
        Method method = aClass.getMethod(methodName, UserService.class);
        //5.反射
        method.invoke(userController, userService);
        System.out.println(userController.getUserService());
    }

    /**
     * 通过反射来赋值
     *
     * @throws NoSuchFieldException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void testAutoWired()
    {
        UserController userController = new UserController();
        Class<? extends UserController> aClass = userController.getClass();

        //1.创建对象
        UserService userService = new UserService();
        Stream.of(aClass.getDeclaredFields()).forEach(field -> {
            String name = field.getName();
            AutoWired annotation = field.getAnnotation(AutoWired.class);
            if (annotation != null)
            {
                field.setAccessible(true);
                /**
                 * 获取属性的类型
                 */
                Class<?> type = field.getType();
                try
                {
                    Object o = type.newInstance();
                    field.set(userController, o);
                }
                catch (InstantiationException e)
                {
                    e.printStackTrace();
                }
                catch (IllegalAccessException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
