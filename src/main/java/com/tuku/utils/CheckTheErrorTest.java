package com.tuku.utils;

import cn.hutool.core.date.DateUtil;
import com.tuku.model.TvPay;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2020-03-10
 * Time: 11:20:25
 * Description:
 * 用于检测项目中可能遇到的错误
 */
public class CheckTheErrorTest
{
    /**
     * flag:测试基于lambda排序过程遇到空字段如何处理的问题
     * result:使用如下的方法是可以避免NPE的，如果直接使用
     * list.sort(Comparator.comparing(TvPay::getCreateTime).reversed());
     * 当比较的字段为空的时候，会报NPE
     */
    @Test
    public void testSortListForNullDate()
    {
        List<TvPay> list = new ArrayList<>();
        for (Long i = 0L; i <2L; i++)
        {
            TvPay build = new TvPay();
            if(i % 2 ==0)
            {
               build = TvPay.builder().id(i).createTime(DateUtil.parseDateTime("2019-12-12 00:00:00")).build();
            }
            else
            {
                build = TvPay.builder().id(i).createTime(DateUtil.parseDateTime("2019-12-13 00:00:00")).build();
            }
            list.add(build);
        }
        for (Long i = 10L; i <12L; i++)
        {
            TvPay build = TvPay.builder().id(i).build();
            list.add(build);
        }

        List<TvPay> collect = list.stream().sorted(Comparator.comparing(TvPay::getCreateTime, Comparator.nullsFirst(Date::compareTo))).collect(Collectors.toList());
        for (TvPay tvPay : collect)
        {
            System.out.println(tvPay);
        }
    }
}
