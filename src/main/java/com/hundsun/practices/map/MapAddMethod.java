package com.hundsun.practices.map;

import com.hundsun.practices.map.model.VarScrEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.hundsun.practices.map
 * @Description: 测试map的putAll与直接赋值的区别，结论：二者没有区别。
 * @Author: zky
 * @CreateDate: 2021/6/21 9:41
 * @UpdateUser: zky
 * @UpdateDate: 2021/6/21 9:41
 * @UpdateRemark: The modified content
 * @DATE: 2021-06-21 09:41
 * @SINCE:
 * @Version: 1.0
 * <p>
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@Slf4j
public class MapAddMethod
{
    @Test
    public void test1()
    {
        Map<String, VarScrEntity> scrMap = new HashMap<>();
        scrMap.put("a", VarScrEntity.builder().connectDpInterCode("a").dpInterCode("a").build());
        scrMap.put("b", VarScrEntity.builder().connectDpInterCode("b").dpInterCode("b").build());
        scrMap.put("c", VarScrEntity.builder().connectDpInterCode("c").dpInterCode("c").build());
        log.info("put...{}", scrMap);

        Map<String, VarScrEntity> map = new HashMap<>();
        map.put("a",VarScrEntity.builder().connectDpInterCode("aa").dpInterCode("aa").build());
        map.put("b",VarScrEntity.builder().connectDpInterCode("bb").dpInterCode("bb").build());
        map.put("c",VarScrEntity.builder().connectDpInterCode("cc").dpInterCode("cc").build());
        scrMap.putAll(map);
        log.info("putAll...{}", scrMap);
        Map<String, VarScrEntity> map1 = new HashMap<>();

        map1.put("a",VarScrEntity.builder().connectDpInterCode("aaa").dpInterCode("aaa").build());
        map1.put("b",VarScrEntity.builder().connectDpInterCode("bbb").dpInterCode("bbb").build());
        map1.put("c",VarScrEntity.builder().connectDpInterCode("ccc").dpInterCode("ccc").build());
        scrMap=map1;
        log.info("==...{}", scrMap);
        Map<String, VarScrEntity> map2 = new HashMap<>();
        map2.put("d",VarScrEntity.builder().connectDpInterCode("d").dpInterCode("d").build());
        map2.put("e",VarScrEntity.builder().connectDpInterCode("e").dpInterCode("e").build());
        map2.put("f",VarScrEntity.builder().connectDpInterCode("f").dpInterCode("f").build());
        scrMap.putAll(map2);
        log.info("key值不等的情况putAll...{}", scrMap);
        Map<String, VarScrEntity> map3 = new HashMap<>();
        map3.put("g",VarScrEntity.builder().connectDpInterCode("g").dpInterCode("g").build());
        map3.put("h",VarScrEntity.builder().connectDpInterCode("h").dpInterCode("h").build());
        map3.put("i",VarScrEntity.builder().connectDpInterCode("i").dpInterCode("i").build());
        scrMap=map3;
        log.info("key值不等的情况赋值...{}", scrMap);


    }
}
