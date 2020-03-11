package com.tuku;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2020-03-05
 * Time: 17:57:31
 * Description:
 */
public class MapTest
{
    /**
     * 测试
     */
    @Test
    public void testMapCollections()
    {
        Map<String,String> map = new HashMap<>();
        map.put("1","1A");
        map.put("2","2B");
        map.put("3","3C");
        map.put("4","4D");
        List<Map.Entry<String, String>> collect = map.entrySet().stream().collect(Collectors.toList());
        System.out.println(collect.get(0));

        List<String> collect1 = map.values().stream().collect(Collectors.toList());

        System.out.println(collect1.get(0));


    }
}
