package com.hundsun.practices.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 文件描述
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


        Map<CommonKey, BusihubIvsmAcc> filterFundAccMap = all.entrySet().stream().filter(entry -> {
            BusihubIvsmAcc acc = entry.getValue();
            String accountLayer = acc.getDpInvestAccountLayer();
            return "01".equals(accountLayer) || "02".equals(accountLayer);
        }).collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> x));
        filterFundAccMap.forEach((key, value) -> {
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
        all.put(CommonKey.builder().investmentAccountCode("A").build(), BusihubIvsmAcc.builder().investmentAccountCode("D1").fundCode("z1").dpInvestAccountLayer("01").build());
        all.put(CommonKey.builder().investmentAccountCode("B").build(), BusihubIvsmAcc.builder().investmentAccountCode("D2").fundCode("z2").dpInvestAccountLayer("02").build());
        all.put(CommonKey.builder().investmentAccountCode("C").build(), BusihubIvsmAcc.builder().investmentAccountCode("D3").fundCode("z3").dpInvestAccountLayer("03").build());
        all.put(CommonKey.builder().investmentAccountCode("D").build(), BusihubIvsmAcc.builder().investmentAccountCode("D4").fundCode("z4").dpInvestAccountLayer("04").build());
        all.put(CommonKey.builder().investmentAccountCode("E").build(), BusihubIvsmAcc.builder().investmentAccountCode("D5").fundCode("z5").dpInvestAccountLayer("05").build());


        List<BusihubIvsmAcc> collect = all.values().stream().collect(Collectors.toList());

        List<BusihubIvsmAcc> collect2 = collect.stream().filter(e -> {
            return "z1".equals(e.getFundCode()) && "01".equals(e.getDpInvestAccountLayer());
        }).collect(Collectors.toList());
        log.info("collect2:{}", collect2);
        Stream<BusihubIvsmAcc> busihubIvsmAccStream = collect.stream().filter(e -> {
            return "z1".equals(e.getFundCode()) && "01".equals(e.getDpInvestAccountLayer());
        });
        ConcurrentMap<String, String> collect1 = busihubIvsmAccStream.collect(Collectors.toConcurrentMap(k -> k.getFundCode(), v -> v.getInvestmentAccountCode(), (m1, m2) -> m1));


        log.info("resultMap:{}", collect1);

    }
}
