package com.tuku.utils;

import cn.hutool.core.date.DateUtil;
import lombok.extern.log4j.Log4j;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;
import org.joda.time.Months;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2020-08-11
 * Time: 15:48:23
 * Description:
 */
@Log4j
class DateUtilsTest
{

    @BeforeEach
    void setUp()
    {
        System.out.println("String...");
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("Ending...");
    }

    @Test
    public void testDatePeriod()
    {
        String start = "2016-08-31";
        String end = "2016-11-30";
        Period between = Period.between(LocalDate.parse(start), LocalDate.parse(end));
        log.info("时间差==="+new StringBuffer().append(between.getYears()).append(",").append(between.getMonths()).append(",").append(between.getDays()).toString());

        log.info("===================================================");

        long between1 = ChronoUnit.MONTHS.between(LocalDate.parse("2016-08-31"), LocalDate.parse("2016-11-30"));
        log.info("between1:day===" + between1);

        String formatDate = DateFormat.getDateInstance().format(new Date());
        System.out.println("当前系统时间=" + formatDate);
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime startDate = formatter.parseDateTime("2016-08-31");
        DateTime endDate = formatter.parseDateTime("2016-12-01");
        System.out.println("开始时间=" + startDate);
        System.out.println("结束时间=" + endDate);
        //end-start 结果可为负数、正数、0
        int months = Months.monthsBetween(startDate, endDate).getMonths();
        int months1 = Months.monthsBetween(DateTime.parse(start), DateTime.parse(end)).getMonths();
        int day3 = Days.daysBetween(startDate, endDate).getDays();

        log.info("months_jorda===" + months);
        log.info("months_jorda1===" + months1);
        log.info("day3===" + day3);


        log.info("=================================================================");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(DateUtils.strToDate("2016-11-30"));
        c2.setTime(DateUtils.strToDate("2016-08-31"));
        if (c1.getTimeInMillis() < c2.getTimeInMillis())
            return;
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        // 获取年的差值 假设 d1 = 2015-8-16  d2 = 2011-9-30
        int yearInterval = year1 - year2;
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if (month1 < month2 || month1 == month2 && day1 < day2)
            yearInterval--;
        // 获取月数差值
        int monthInterval = (month1 + 12) - month2;
        if (day1 < day2)
            monthInterval--;
        monthInterval %= 12;
        Integer i = yearInterval * 12 + monthInterval;

        log.info("IIIIIII==="+i);

        log.info("========================================================");
        long l = DateUtil.betweenMonth(DateUtils.strToDate("2020-08-31"), DateUtils.strToDate("2020-11-30"), true);
        long l1 = DateUtil.betweenDay(DateUtils.strToDate("2020-08-31"), DateUtils.strToDate("2020-11-30"), true);

        log.info("l==="+l);
        log.info("l1==="+l1);

        /**
         * 这个符合要求。
         */
        Interval interval = new Interval(DateTime.parse("2020-08-31"), DateTime.parse("2020-11-30"));
        org.joda.time.Period period = interval.toPeriod();

        log.info("=======================================================================");
        log.info(period.getYears()+" 年 "+period.getMonths()+" 月 "+period.getDays()+" 日");
    }
}