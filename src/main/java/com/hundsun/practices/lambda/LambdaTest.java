package com.hundsun.practices.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: AllKindsOfItems
 * @Package: com.hundsun.practices.lambda
 * @Description: note
 * @Author: zky
 * @CreateDate: 2021/4/18 0:08
 * @UpdateUser: zky
 * @UpdateDate: 2021/4/18 0:08
 * @UpdateRemark: The modified content
 * @DATE: 2021-04-18 00:08
 * @SINCE:
 * @Version: 1.0
 * <p>
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@Slf4j
public class LambdaTest
{
    @Test
    public void test()
    {
        Map<CommonKey, BusihubIvsmAcc> all = new ConcurrentHashMap<>();
        all.put(CommonKey.builder().investmentAccountCode("A").build(), BusihubIvsmAcc.builder().dpInvestAccountLayer("01").assetCode("X0").build());
        all.put(CommonKey.builder().investmentAccountCode("B").build(), BusihubIvsmAcc.builder().dpInvestAccountLayer("02").build());
        all.put(CommonKey.builder().investmentAccountCode("C").build(), BusihubIvsmAcc.builder().dpInvestAccountLayer("03").build());
        all.put(CommonKey.builder().investmentAccountCode("D").build(), BusihubIvsmAcc.builder().dpInvestAccountLayer("04").build());
        all.put(CommonKey.builder().investmentAccountCode("E").build(), BusihubIvsmAcc.builder().dpInvestAccountLayer("05").build());
        all.put(CommonKey.builder().investmentAccountCode("F").build(), BusihubIvsmAcc.builder().dpInvestAccountLayer("06").build());
        all.put(CommonKey.builder().investmentAccountCode("A").build(), BusihubIvsmAcc.builder().dpInvestAccountLayer("01").assetCode("X4").build());
        all.put(CommonKey.builder().investmentAccountCode("G").build(), BusihubIvsmAcc.builder().dpInvestAccountLayer("01").assetCode("X1").build());
        all.put(CommonKey.builder().investmentAccountCode("H").build(), BusihubIvsmAcc.builder().dpInvestAccountLayer("01").assetCode("X2").build());
        all.put(CommonKey.builder().investmentAccountCode("I").build(), BusihubIvsmAcc.builder().dpInvestAccountLayer("01").assetCode("X3").build());


        Map<CommonKey, BusihubIvsmAcc> filterFundAccMap = all.entrySet()
                                                             .stream()
                                                             .filter(entry ->
                                                                     {
                                                                         BusihubIvsmAcc acc = entry.getValue();
                                                                         String accountLayer = acc.getDpInvestAccountLayer();
                                                                         return "01".equals(accountLayer)||"02".equals(accountLayer);
                                                                     })
                                                             .collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue, (x,y)->x));
        filterFundAccMap.forEach((key, value) ->
                                 {
                                     System.out.print(key.getInvestmentAccountCode());
                                     System.out.print("<==>");
                                     System.out.print(value.getDpInvestAccountLayer());
                                     System.out.print("<==>");
                                     System.out.print(value.getAssetCode());
                                     System.out.println();
                                 });
    }

    @Test
    public void test1()
    {
        Map<CommonKey, BusihubIvsmAcc> all = new ConcurrentHashMap<>();
        all.put(CommonKey.builder().investmentAccountCode("A").build(), BusihubIvsmAcc.builder().fundCode("888").dpInvestAccountLayer("01").build());
        all.put(CommonKey.builder().investmentAccountCode("B").build(), BusihubIvsmAcc.builder().fundCode("999").dpInvestAccountLayer("02").build());
        all.put(CommonKey.builder().investmentAccountCode("C").build(), BusihubIvsmAcc.builder().fundCode("777").dpInvestAccountLayer("03").build());
        all.put(CommonKey.builder().investmentAccountCode("D").build(), BusihubIvsmAcc.builder().fundCode("666").dpInvestAccountLayer("04").build());
        all.put(CommonKey.builder().investmentAccountCode("E").build(), BusihubIvsmAcc.builder().fundCode("555").dpInvestAccountLayer("05").build());

        Map<String,Map<CommonKey,BusihubIvsmAcc>> allMap = new ConcurrentHashMap<>();
        allMap.put("yyyyy",all);

        List<BusihubIvsmAcc> collect = all.values().stream().collect(Collectors.toList());
        ConcurrentMap<String, String> resultMap = collect.stream().filter(e -> {
            return "888".equals(e.getFundCode()) && "01".equals(e.getDpInvestAccountLayer());
        }).collect(Collectors.toConcurrentMap(k -> k.getFundCode(), v -> v.getInvestmentAccountCode(), (m1, m2) -> m1));

        log.info("resultMap:{}",resultMap);

    }

    @Test
    public void test2()
    {
        Map<CommonKey, BusihubIvsmAcc> all = new ConcurrentHashMap<>();
        all.put(CommonKey.builder().investmentAccountCode("A").build(), BusihubIvsmAcc.builder().fundCode("888").dpInvestAccountLayer("01").build());
        all.put(CommonKey.builder().investmentAccountCode("B").build(), BusihubIvsmAcc.builder().fundCode("999").dpInvestAccountLayer("02").build());
        Map<String,Map<CommonKey,BusihubIvsmAcc>> allMap = new ConcurrentHashMap<>();
        allMap.put("yyyyy",all);
        Map<CommonKey, BusihubIvsmAcc> all1 = new ConcurrentHashMap<>();
        all1.put(CommonKey.builder().investmentAccountCode("A1").build(), BusihubIvsmAcc.builder().fundCode("8881").dpInvestAccountLayer("011").build());
        all1.put(CommonKey.builder().investmentAccountCode("B1").build(), BusihubIvsmAcc.builder().fundCode("9991").dpInvestAccountLayer("021").build());
        allMap.put("yyyyy1",all1);

        log.info("allMap:{}",allMap);
        all.remove(CommonKey.builder().investmentAccountCode("A").build());
        // allMap.put("yyyyy",all);
        log.info("allMap:{}",allMap);

    }
}
