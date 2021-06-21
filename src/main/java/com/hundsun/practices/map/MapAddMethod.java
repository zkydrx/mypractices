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
        Map<String, VarScrEntity> scrMap =new HashMap<>();
        scrMap.put("a",VarScrEntity.builder().connectDpInterCode("a").dpInterCode("1").build());
        scrMap.put("b",VarScrEntity.builder().connectDpInterCode("b").dpInterCode("2").build());
        scrMap.put("c",VarScrEntity.builder().connectDpInterCode("c").dpInterCode("3").build());
        log.info("put...{}",scrMap.toString());

        Map<String, VarScrEntity> map = new HashMap<>();
        map.put("a",VarScrEntity.builder().connectDpInterCode("a1").dpInterCode("11").build());
        map.put("b",VarScrEntity.builder().connectDpInterCode("b2").dpInterCode("22").build());
        map.put("c",VarScrEntity.builder().connectDpInterCode("c3").dpInterCode("33").build());
        scrMap.putAll(map);
        log.info("putAll...{}",scrMap.toString());

        map.put("a",VarScrEntity.builder().connectDpInterCode("a11").dpInterCode("111").build());
        map.put("b",VarScrEntity.builder().connectDpInterCode("b22").dpInterCode("222").build());
        map.put("c",VarScrEntity.builder().connectDpInterCode("c33").dpInterCode("333").build());
        scrMap=map;
        log.info("==...{}",scrMap.toString());

        map.put("d",VarScrEntity.builder().connectDpInterCode("d").dpInterCode("d").build());
        map.put("e",VarScrEntity.builder().connectDpInterCode("e").dpInterCode("e").build());
        map.put("f",VarScrEntity.builder().connectDpInterCode("f").dpInterCode("f").build());
        scrMap.putAll(map);
        log.info("key值不等的情况putAll...{}",scrMap.toString());

        map.put("g",VarScrEntity.builder().connectDpInterCode("g").dpInterCode("g").build());
        map.put("h",VarScrEntity.builder().connectDpInterCode("h").dpInterCode("h").build());
        map.put("i",VarScrEntity.builder().connectDpInterCode("i").dpInterCode("i").build());
        scrMap=map;
        log.info("key值不等的情况赋值...{}",scrMap.toString());


    }
}
