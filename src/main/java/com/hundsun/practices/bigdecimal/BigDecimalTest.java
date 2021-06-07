package com.hundsun.practices.bigdecimal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.hundsun.practices.bigdecimal
 * @Description: note
 * @Author: zky
 * @CreateDate: 2021/6/7 14:48
 * @UpdateUser: zky
 * @UpdateDate: 2021/6/7 14:48
 * @UpdateRemark: The modified content
 * @DATE: 2021-06-07 14:48
 * @SINCE:
 * @Version: 1.0
 * <p>
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@Slf4j
public class BigDecimalTest
{
    @Test
    public void testDivid()
    {
        BigDecimal bigDecimal = new BigDecimal(311L);
        BigDecimal divide = bigDecimal.divide(BigDecimal.valueOf(2L), 2, RoundingMode.HALF_UP);
        log.info("divide:{}",divide);
    }

}
