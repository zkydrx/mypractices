package com.zhihei.jdk8.example.forall;


import com.zhihei.jdk8.example.moudle.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-10
 * Time: 12:44:18
 * Description:
 */
public class EmployeeExample
{
    private static List<Employee> employees = new ArrayList<>();

    static
    {
        employees.add(Employee.builder().name("Anmy").salary(15000).office("ChongQing").build());
        employees.add(Employee.builder().name("Tom").salary(18000).office("ShangHai").build());
        employees.add(Employee.builder().name("Abbot").salary(23000).office("HangZhou").build());
        employees.add(Employee.builder().name("Tina").salary(20000).office("BeiJing").build());
        employees.add(Employee.builder().name("John").salary(21000).office("ShenZhen").build());
        employees.add(Employee.builder().name("Hony").salary(31000).office("ShenZhen").build());
        employees.add(Employee.builder().name("Jany").salary(38000).office("HangZhou").build());
        employees.add(Employee.builder().name("Jobs").salary(29000).office("HangZhou").build());
    }

    public static void main(String[] args)
    {

        /**
         * 匹配办公室为杭州的雇员
         */
        boolean hangZhou = employees.stream().anyMatch(employee -> employee.getOffice().equals("HangZhou"));
        System.out.println(hangZhou);

        /**
         * 返回所有salary大于20000的雇员
         */
        boolean b = employees.stream().allMatch(employee -> employee.getSalary() > 2000);
        System.out.println(b);

        /**
         * 找出salary最高的雇员方法一
         */
        Optional<Employee> max = employees.stream().max((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));
        /**
         * 找出salary最高的雇员方法二
         */
        Optional<Employee> max1 = employees.stream().max(Comparator.comparing(Employee::getSalary));
        /**
         * 找出salary最高的雇员方法3
         */
        Optional<Employee> max2 = employees.stream().max(Comparator.comparingInt(Employee::getSalary));

        System.out.println("找出salary最高的雇员方法1:" + max);
        System.out.println("找出salary最高的雇员方法2:" + max1);
        System.out.println("找出salary最高的雇员方法3:" + max2);

        /**
         * 找出salary 最少的雇员方法1：
         */
        Optional<Employee> min = employees.stream().min((e1,e2) -> e1.getSalary()-e2.getSalary());
        /**
         * 找出salary 最少的雇员方法2：
         */
        Optional<Employee> min1 = employees.stream().min(Comparator.comparingInt(Employee::getSalary));
        /**
         * 找出salary 最少的雇员方法3：
         */
        Optional<Employee> min2 = employees.stream().min((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));

        System.out.println("找出salary 最少的雇员方法1:"+min);
        System.out.println("找出salary 最少的雇员方法2:"+min1);
        System.out.println("找出salary 最少的雇员方法3:"+min2);


        /**
         * 返回姓名列表
         */
        List<String> collect = employees.stream().map(a -> a.getName()).collect(Collectors.toList());

        System.out.println("返回姓名列表:\n" + collect);
        /**
         * List转换成Map
         */
        Map<String, Employee> collect1 = employees.stream().collect(Collectors.toMap((employee -> employee.getName()), (employee -> employee)));
        System.out.println("list 转成map方法1:");
        collect1.forEach((k, v) -> System.out.println(k + "::" + v));
        System.out.println("list 转成map方法2:");
        collect1.entrySet().stream().collect(Collectors.toList()).forEach(System.out::println);
        /**
         * 统计办公室是“HangZhou”的数量
         */
        long hangZhou1 = employees.stream().filter(employee -> employee.getOffice().equals("HangZhou")).count();

        System.out.println("办公室是HangZhou的数量是：" + hangZhou1);
        /**
         * List转换为Set
         */
        Set<String> collect2 = employees.stream().map(employee -> employee.getOffice()).collect(Collectors.toSet());
        System.out.println("List转换为Set:" + collect2);
        /**
         * 查找办公司的地点是HangZhou的雇员
         */
        List<Employee> hangZhou2 = employees.stream().filter(employee -> employee.getOffice().equals("HangZhou")).collect(Collectors.toList());

        System.out.println("查找办公司的地点是HangZhou的雇员方法:");
        hangZhou2.forEach(System.out::println);
        Optional<Employee> any = employees.stream().filter(employee -> "HangZhou".equals(employee.getOffice())).findAny();
        System.out.println("查找办公司的地点是HangZhou的任意一个员工" + any);
        /**
         * 按照工资的降序来列出员工信息
         */
        List<Employee> collect3 = employees.stream().sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary())).collect(Collectors.toList());

        System.out.println("按照工资的降序来列出员工信息方法1:");
        collect3.forEach(System.out::println);
        System.out.println("按照工资的降序来列出员工信息方法2:");
        List<Employee> collect5 = employees.stream().sorted((e1, e2) -> e2.getSalary() - e1.getSalary()).collect(Collectors.toList());
        collect5.forEach(System.out::println);

        /**
         * 按照员工名字的升序列出员工信息:
         */
        System.out.println("按照员工名字的升序列出员工信息:");
        List<Employee> collect4 = employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        collect4.forEach(System.out::println);

        /**
         * 获取工资最高的前两条雇员信息:
         */
        List<Employee> collcet5 = employees.stream().sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary())).collect(Collectors.toList()).subList(0, 2);

        System.out.println("获取工资最高的前两条雇员信息方法1:");
        collcet5.forEach(System.out::println);
        List<Employee> collect6 = employees.stream().sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary())).limit(2).collect(Collectors.toList());
        System.out.println("获取工资最高的前两条雇员信息方法2:");
        collect6.forEach(System.out::println);

        /**
         * 获取平均工资
         */
        double average = employees.stream().collect(Collectors.summarizingInt(employees -> employees.getSalary())).getAverage();
        System.out.println("获取平均工资方法1：average = " + average);

        OptionalDouble average1 = employees.stream().mapToInt(e -> e.getSalary()).average();
        System.out.println("获取平均工资方法2：average1 = " + average1.getAsDouble());

        double average2 = employees.stream().mapToInt(e -> e.getSalary()).summaryStatistics().getAverage();

        System.out.println("获取平均工资方法3：average2 = " + average2);

        /**
         * 查找HangZhou雇员的平均薪资
         */
        OptionalDouble average3 = employees.stream().filter(employee -> "HangZhou".equals(employee.getOffice())).mapToInt(e -> e.getSalary()).average();

        System.out.println("HangZhou的雇员平均薪资是："+average3.getAsDouble());

        /**
         * 按照办公室进行分组
         */
        Map<String, List<Employee>> collect7 = employees.stream().collect(Collectors.groupingBy(e -> e.getOffice()));


        System.out.println("按照公司进行分组：");
        collect7.entrySet().forEach(System.out::println);

        Optional<Employee> hangZhou3 = employees.stream().filter(employee -> employee.getOffice().equals("HangZhou")).findFirst();
        System.out.println(hangZhou3);

        /**
         * 获取每个雇员的姓名的首字母
         */
        System.out.println("获取每个雇员的姓名的首字母:");
        employees.stream().map(employee -> employee.getName()).map(e->e.substring(0,1)).collect(Collectors.toList()).forEach(e-> System.out.print(e+" "));
    }
}
