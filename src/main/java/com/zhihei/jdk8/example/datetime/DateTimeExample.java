package com.zhihei.jdk8.example.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-10
 * Time: 14:32:33
 * Description:"
 */
public class DateTimeExample
{
    public static void main(String[] args)
    {
        LocalDate localDate = LocalDate.now();

        System.out.println("当前日期：" + localDate);
        System.out.println("year:" + localDate.getYear() + " month:" + localDate.getMonthValue() + " day:" + localDate.getDayOfMonth());

        System.out.println("获取指定日期");
        LocalDate of = LocalDate.of(2009, 11, 24);
        System.out.println(of);

        System.out.println("比较两个时间的顺序以及是否相等");
        /**
         * 比较两个日期是否相等
         */
        if (localDate.equals(of))
        {
            System.out.println("这俩日期是相等的");
        }
        else
        {
            System.out.println("这俩日期不等");
        }

        /**
         * isAfter 和isBefore比较两个日期的前后顺序
         */
        if (localDate.isAfter(of))
        {
            System.out.println("isAfter：：：：：：：localDate 在of日期后边");
        }
        else
        {
            System.out.println("isAfter：：：：：：：localDate 在of日期前面");
        }
        if (localDate.isBefore(of))
        {
            System.out.println("isBefore：：：：：localDate 在 of 日期前面");
        }
        else
        {
            System.out.println("isBefore：：：：：localDate 在of日期后边");
        }

        /**
         * 日期加减运算
         */
        System.out.println("日期加运算");
        System.out.println("两年后:" + localDate.plusYears(2));
        System.out.println("30个月后:" + localDate.plusMonths(30));
        System.out.println("17周后:" + localDate.plusWeeks(17));
        System.out.println("10天后:" + localDate.plusDays(10));
        System.out.println("日期减运算:");
        System.out.println("19年前:" + localDate.minusYears(19));
        System.out.println("11个月前:" + localDate.minusMonths(11));
        System.out.println("17周前:" + localDate.minusWeeks(17));
        System.out.println("133天以前:" + localDate.minusDays(133));

        /**
         * 获取某年第n天的日期
         */
        LocalDate localDate1 = LocalDate.ofYearDay(2001, 129);

        System.out.println("获取某年第n天的日期:localDate1:" + localDate1);
        /**
         * 获取两个日期的间隔天数
         */
        long l = localDate.toEpochDay() - of.toEpochDay();
        System.out.println("取两个日期的间隔天数:" + l);

        LocalTime localTime = LocalTime.now();
        System.out.println("当前时间:" + localTime);

        System.out.println("hour:" + localTime.getHour() + " minute:" + localTime.getMinute() + " second:" + localTime.getSecond());

        LocalTime of1 = LocalTime.of(15, 32, 21);

        if (localTime.equals(of1))
        {
            System.out.println("equals:两个时间不相等");
        }
        else
        {
            System.out.println("equals:两个时间相等");
        }

        /**
         *  isAfter 和isBefore比较两个时间的前后顺序
         */
        if (localTime.isBefore(of1))
        {
            System.out.println("isBefore: localTime 在of1前面");
        }
        else
        {
            System.out.println("isBefore: localTime 在of1侯面");
        }

        if (localTime.isAfter(of1))
        {
            System.out.println("isAfter: localTime 在of1后面");
        }
        else
        {
            System.out.println("isAfter: localTime 在of1前面");
        }
        /**
         *  时间的加减
         */
        System.out.println("1小时后"+localTime.plusHours(1));
        System.out.println("2分钟后"+localTime.plusMinutes(2));
        System.out.println("30秒后"+localTime.plusSeconds(30));
        System.out.println("当前时间:"+localTime);
        System.out.println("400毫秒后:"+localTime.plus(400, ChronoUnit.MILLIS));
        System.out.println("100微秒后:"+localTime.plus(100, ChronoUnit.MICROS));
        System.out.println("900纳秒后"+localTime.plusNanos(900));

        System.out.println("1小时前:"+localTime.minusHours(1));
        System.out.println("2分钟前:"+localTime.minusMinutes(2));
        System.out.println("50秒前:"+localTime.minusSeconds(50));
        System.out.println("当前时间:"+localTime);
        System.out.println("600毫秒前:"+localTime.minus(600,ChronoUnit.MILLIS));
        System.out.println("200微秒前:"+localTime.minus(200,ChronoUnit.MICROS));
        System.out.println("500纳秒前:"+localTime.minusNanos(500));


        /**
         * 指定获取日期时间
         */
        LocalDateTime now = LocalDateTime.now();

        System.out.println("当前的日期和时间:"+now);
        LocalDateTime of2 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("当前的日期和时间:"+of2);

        LocalDate localDate2 = of2.toLocalDate();
        LocalTime localTime1 = of2.toLocalTime();

        System.out.println("localDate2转化:"+localDate2);
        System.out.println("localTime1转化:"+localTime1);
    }
}
